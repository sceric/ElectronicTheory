;************************************
;*
;*   DTMF functions

;**** All DTMF data is fetched via interrupt
;* therefore the interrupt function is placed here.

int_init	; Interrupt register init function
	page1
	bsf	OPTREG,RTS	; Select counter mode
	bcf	OPTREG,RTE	; Select rising edge to increase counter
	bsf	OPTREG,PSA	; Don't use prescaler with counter
	page0
	movlw	0FFh		; Set Timer counter to 0FFh
	movwf	TMR0
	bsf	INTCON,T0IE	; Enable TMR0 interrupt
	bsf	INTCON,GIE	; Global interrupt enable
	return

interrupt
	movwf	int1		; Save W register
	swapf	STATUS,W	
	movwf	int2		; Save STATUS register
	page1			; Select page 1
	swapf	TRISB,W		
	movwf	int3		; Save TRISB
	pbin			; Make sure port B is input
	btfss	INTCON,T0IF	; Check if timer interrupt
	goto	inter1		; if not, restore and leave
	goto	getdtmf		; Get DTMF data
inter0	bcf	INTCON,T0IF	; Reset interrupt bit
	movlw	0FFh		; Set timer counter to 0FFh
	movwf	TMR0
inter1	page1
	swapf	int3,W
	movwf	TRISB
	swapf	int2,W		
	movwf	STATUS		; Restore STATUS register
	swapf	int1,F
	swapf	int1,W		; Restore W register
	page0
	retfie

getdtmf
	bcf     PORTA,DBEN      ; Enable DTMF data output
	call	delay8
	movf    PORTB,W         ; Move DTMF data to W
	bsf     PORTA,DBEN      ; Disable DTMF data output
	andlw   0fh             ; Only bits 0-3 is valid
	movwf	inttmp		; save data in tmp register
	goto	d_check		; Check for control token
inter2	btfsc	STATUS,Z	; If control token we're finished here
	goto	inter0		; Was control, go back

	btfss	flags,DTMF_IN	; If we're not receiving
	goto	inter0		; then go back
	movf	inttmp,W	
	sublw   0ah             ; Check if DTMF code for zero
	btfsc   STATUS,Z        ; If zero flag set (= code for zero)
	clrf    inttmp          ; then set tmp=0 to get correct value in W
	movf    inttmp,W        ; Set W = tmp (=0 if DTMF code for zero)
	addlw   030h            ; Add 30h to W to get ASCII value
	movwf	IADDR		; Store in DTMF-digit storage area
	incf	FSR,F		; Point to next pos in storage area
	call	lcdwr		; Output digit to LCD
	goto	inter0

;**** Check if control token
d_check

;#DEFINE _TEST
#IFNDEF _TEST
	btfsc	STATUS,Z	; Check if zero = control
	goto	got_D		; Yes, got a D
	andlw	0ch		; Mask off all bits but 2 and 3
	sublw	0ch		; Check if other control data, # will slip through
	btfss	STATUS,Z	; if zero -> control
	goto	inter2		; Not control, go back
#ENDIF

#IFDEF	_TEST
test	xorlw	0Bh		; Check if DTMF code for * (my test start code)
	btfss	STATUS,Z	
	goto	test1		; no, check if test stop code
	goto	d_chk5		; Was start
test1	movf	inttmp,W
	xorlw	0Ch		; Check if DTMF code for # (my test stop code)
	btfss	STATUS,Z	
	goto	test2		; Wasn't stop, check if infocode
	goto	test4		; Was stop
test2	movf	inttmp,W
	xorlw	09h		; Check if DTMF code for 9 (my test infocode code)
	btfss	STATUS,Z	
	goto	test3		; Wasn't infocode, check if relayed
	goto	test5		; Was infocode
test3	movf	inttmp,W	; Check if DTMF code for 8 (my test relayed code)
	xorlw	08h
	btfss	STATUS,Z	
	goto	inter2		; Wasn't any control, go back
	goto	got_D		; Was relayed
;end of test
#ENDIF

d_chk1
	movf	inttmp,W
	xorlw	0dh		; Check if DTMF code for A (start code)
	btfss	STATUS,Z	
	goto 	d_chk2		; No
d_chk5	bsf	flags,DTMF_IN
	movlw	CLEAR		; Clear Display	
	call	lcdcmd	
	goto	set_pointer
d_chk2
	movf	inttmp,W
	xorlw	0eh		; Check if DTMF code for B (start infocode)
	btfss	STATUS,Z
	goto	d_chk3		; No
test5	btfss	flags,DTMF_IN	; Check if we are already receiving
	goto	d_chk5		; No, this is start
	bsf	flags,DTMF_RD	; Call has been relayed
	movlw	RELAYED		; Add relay token (Right arrow) to indicate relayed call
	movwf	IADDR
	incf	FSR,F		; Point to next pos in copy area
	call	store		; Store last number 
	movlw	CLEAR
	call	lcdcmd
	goto	set_pointer
d_chk3
	movf	inttmp,W
	xorlw	0fh		; Check if DTMF code for C (stop)
	btfss   STATUS,Z        
	goto	inter2		; no control detected, probably a # then
test4	bcf	flags,DTMF_IN	; Was stop, reset DTMF_IN flag
	bsf	flags,DTMF_ST	; Set stop flag
	incbcd	totnum
	btfsc	flags,DTMF_RD 	; Check if relayed call
	goto	d_chk4		; yes, call relayed
	call	store		; Store number 
	goto	set_pointer
d_chk4	movlw	RELEND		; Add relay end token to indicate relayed call
	movwf	IADDR
	call	lcdwr		; Write the relay end mark to display
	incf	FSR,F		; Point to next pos in copy area
	call	store
	bcf	flags,DTMF_RD
	goto	set_pointer

got_D				; We got a D, dtmf code for new or relayed call
	btfss	flags,DTMF_IN	; Check if we are already receiving
	goto	d_chk5		; No, this is start
	bsf	flags,DTMF_RD	; Call has been relayed
	movlw	RELAYED		; Add relay token (Right arrow) to indicate relayed call
	movwf	IADDR
	incf	FSR,F		; Point to next pos in copy area
	call	store		; Store last number 
	movlw	CLEAR		; Clear Display
	call	lcdcmd
set_pointer
	movlw	C_START		; Set FSR to point to first position in 
	movwf	FSR		; DTMF-digit storage area.
	bsf	STATUS,Z	; Indicate we have got a control token
	goto	inter2

;**** Stores number and date/time in external EEPROM
store
	movlw	NDSEP		; Write number/date separator at
	movwf	IADDR		; end of number
	movwf	i2cdata		; Use NDSEP as end mark for I2C sequential write
	bsf	flags,SEQCTRL	; Sequential write until data = i2cdata
	call	store_i2c	; store number in I2C EEPROM
	call	get_time	; Get time from RTC
	movlw	EONR		; Write end of number mark at 
	movwf	IADDR		; end of time data
	movlw	.6
	movwf	i2cdata		; Write 6 bytes in sequential write
	bcf	flags,SEQCTRL	; Write a specific number of sequential bytes 
	call	store_i2c	; Store time with number
;	call	put_time	; Write time to lcd
	return

store_i2c
	bsf	flags,EE_RTC	; Set EEPROM communication
	movlw	C_START
	movwf	FSR		; Set data pointer to beginning of copy area
	movf	endaddr,W	
	movwf	i2caddr		; Set start address in I2C EEPROM
	movf	endblk,W
	movwf	i2cblk		; Set start block in I2C EEPROM
	call	i2cseqw		; Write data to I2C EEPROM
	incf	i2caddr,F	; Increase I2C address pointer
	btfsc	STATUS,Z	; Check if wrap occured
	incf	i2cblk,F	; If so, increase block pointer
	;****************  insert som sort of mem control ***********************
	movf	i2caddr,W
	movwf	endaddr		; Set new end address
	movf	i2cblk,W
	movwf	endblk		; Set new end block
	movlw	EODB		; End Of DataBase mark
	movwf	i2cdata
	call	i2cbwr		; Write end of data marker
	return





