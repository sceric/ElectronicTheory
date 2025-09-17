;************************************
;*
;*   Database functions

;**** Search for end of database
get_end
	bsf	flags,EE_RTC	; Select EEPROM communication
	clrf	totnum	
	clrf	endaddr
	clrf	endblk
	clrf	i2caddr		; Start from beginning
	clrf	i2cblk		; of memory
	call	i2crar		; Make a random address read of first position
gete1	movf	i2cdata,W
	sublw	EODB		; Check if End Of DataBase mark
	btfsc	STATUS,Z	; If so,
	return			; we have found the end and are finished
	movf	i2cdata,W
	sublw	EONR		; Check if End Of Number
	btfss	STATUS,Z	; If so, increase totnum
	goto	gete3		; Since incbcd is a macro it can't be preceeded by a condition
	incbcd	totnum		; Since incbcd is a macro it can't be preceeded by a condition
gete3	incf	endaddr,F	; Next position
	btfss	STATUS,Z	; Check if wraparound occured
	goto	gete0		; No
	incf	endblk,F	; End of block, go on to next
	btfsc	endblk,.3	; Check if end of memeory
	goto	seteodb		; No end of data mark found
	;**** If this routine is changed to use sequential read instead the
	;**** rows below will be unnecessary
	movf	endaddr,W
	movwf	i2caddr
	movf	endblk,W
	movwf	i2cblk
	call	i2crar
	goto	gete1

gete0	call	i2ccar		; Read next position
	goto	gete1		; and start over

seteodb				; Set end of database mark at beginning of mem
	clrf	i2cblk		
	clrf	i2caddr
	movlw	EODB		; End Of DataBase mark
	movwf	i2cdata
	call	i2cbwr		; Write end mark to EEProm
	clrf	endaddr		; Set end of mark pointers
	clrf	endblk
	return


;**** Show next number 
; This function demands that the I2C pointers are correct
; ie points at the beginning of the number to show
shownext
	movf	i2caddr,W	
	subwf	endaddr,W	; Check if end address
	btfsc	STATUS,Z	; 
	goto	sn2		; Check block to be sure
sn1	bsf	flags,EE_RTC	; Select EEPROM communication
	bsf	flags,SEQCTRL	; Read until data = i2cdata
	movlw	NDSEP		; ie. read until Number/Date SEParator
	movwf	i2cdata
	call	i2cseqr		
	decf	FSR,F
	clrf	IADDR		; Write zero at end of data
	call	lcdinit		; Clear display
	call	putlcd		; Write the number to the display
	movlw	SPEJS
	call	lcdwr		; Write a space to the display
	movlw	C_START+1	
	movwf	FSR		; Set FSR at second position of copyarea
	movlw	ROW1+LCD_L-5	; Set lcd cursor pos five steps in from end of row 1
	call	lcdcmd
	movf	curnum,W	; Move current number count to copy area
	movwf	IADDR
	clrf	tmp
	bsf	tmp,IN_SPCE	; Insert space instead of leading zero
sn3	call	bcd_out		; Write number
	movlw	SLASH
	call	lcdwr		; Write a slash to the display
	movf	totnum,W	; Move total number count to copy area
	movwf	IADDR
	bcf	tmp,IN_SPCE	; Don't insert space
	bsf	tmp,RL_ZERO	; Remove leading zero instead
	call	bcd_out		; Write the count
	movlw	EONR		; Get time, read until End Of NumbeR mark
	movwf	i2cdata
	call	i2cseqr		; Get the time
	clrf	IADDR		; Write zero at end of data
	call	put_time	; Write the time to the display
	incbcd	curnum		; Increase current number counter
	return
sn2	movf	i2cblk,W
	subwf	endblk,W	; Check if end block
	btfss	STATUS,Z
	goto 	sn1		; Not end block, continue
	return			; Yes end block, do nothing

;**** Show previous number 
; This function demands that the I2C pointers are correct
; ie points at the beginning of the number after the one currently shown.
; To show correct number we must go two back since we're positioned after
; the one currently present on the display
showprev
	movf	curnum,W
	sublw	02h		; Check if curnum=2
	btfsc	STATUS,Z
	return			; We're already at the beginning
sp1	call	getprev		; Put I2C pointers at beginning of prevoius number
	call	getprev		; Put I2C pointers at beginning of prevoius number
	call	shownext	; Write the number to the display
	return

;**** Puts I2C pointers at the beginning of the prevoius number
getprev
	call	deci2c		; Decrease I2C address
	call	deci2c		; Decrease I2C address
gp1	call	i2crar		; Get data
	movlw	EONR		; Put End Of Number mark i W register
	subwf	i2cdata,W	; Check if we're at the end of a number
	btfsc	STATUS,Z
	goto	gp2		; If so, we're almost finished
	call	deci2c		; otherwise check preceeding character
	movf	i2caddr,W	; Check if we're at the beginning
	btfss	STATUS,Z
	goto	gp1		; Address<>0 cannot be at the beginnig
	movf	i2cblk,W
	btfss	STATUS,Z
	goto	gp1		; Block<>0 cannot be at the beginning
	decbcd	curnum		; We're at the beginning,
	return			; ie we're finished
gp2	incf	i2caddr,F	; Increase address to put pointer right
	btfss	STATUS,Z	; Check if wraparound
	goto	gp3		; No, we're finished
	incf	i2cblk,F	; Yes wraparound, increase block
gp3	decbcd	curnum		; Decrease current number counter 2 steps
	return			; and we're finished

;**** Decrease I2C pointers one step
deci2c
	movf	i2caddr,F	; Check if we're about to wraparound backwards
	btfsc	STATUS,Z
	goto	di1		; Yes wraparound
	decf	i2caddr,F	; No, decrease address and continue
	return
di1	movf	i2cblk,F	; Check if we're at the beginning
	btfsc	STATUS,Z	
	return			; Yes, we're at the beginning, do nothing
	decf	i2caddr,F	; Decrease address, ie wraparound to FFhex
	decf	i2cblk,F	; Decrease block
	return

;**** This function erases all numbers beginning from the one displayed
; and all the way to the end, this is done by setting the End Of DataBase
; marker at the beginning of the currently displayed number
; It erases all numbers if the button 4 has been pressed.
erasenum
	call	isempty		; Check if database already empty
	btfsc	STATUS,Z
	goto	en4		; Yes, database empty
en0	call	lcdinit
	movlw	ROW1+LCD_L/2-ERASE_L/2	
	movlw	LCD_L/2-YN_L/2	; Center second row
	movwf	tmp
	movlw	ERASE		; Output Really erase question to display
	call	wrtxt
en1	call	get_but		
	btfsc	STATUS,Z	; Wait until button pressed
	goto	en1
	btfsc	tmp,BUT2	; If button 2 (Yes) pressed
	goto	en2		; then erase from current number to last
	btfsc	tmp,BUT3	; If button 3 (No) pressed
	goto	en3		; then restore display
	btfsc	tmp,BUT1	; If Button 1 pressed
	goto	en1		; then do nothing
	call	seteodb		; Button 4 (All) pressed, erase all numbers
	goto	en4		; Output no numbers text to display and return
en2	call	getprev		; Put I2C pointers at currently displayed number
	movlw	EODB	
	movwf	i2cdata	
	call	i2cbwr		; Write EODB at current position to set new end position
	movf	i2caddr,W	
	movwf	endaddr		; Store new endaddress
	movf	i2cblk,W
	movwf	endblk		; Store new end block
en3	call	getprev		; Put pointers at beginning of the number to display
	movf	curnum,W
	movwf	totnum		; Store new total number count
	call	st_prsd		; Wait until buttons released
	call	isempty		; Check if database empty
	btfsc	STATUS,Z
	goto	en4		; Yes, database empty
	call	shownext	; Not empty, write number to the display
	return
en4	call	lcdinit
	movlw	ROW1+(LCD_L/2-DOR_L/2)	; Center first row
	call	lcdcmd		
	movlw	LCD_L/2-NON_L/2	; Center second row
	movwf	tmp
	movlw	NONUMB
	call	wrtxt		; Write No numbers text to display
	clrf	totnum		; Reset total numbers count
	return

;**** Checks if the database is empty
; returns with Z bit set if that's the case
isempty
	movf	endaddr,F	; Check if database already empty
	btfss	STATUS,Z
	return			; End address<>0, can't be empty
	movf	endblk,F
	btfss	STATUS,Z	
	return			; End block<>0, can't be empty
	bsf	STATUS,Z	; Database empty
	return			











