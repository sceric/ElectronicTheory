;************************************
;*   I2C Functions


; ****** High level i2c functions ******

;**** Current address read
i2ccar
	call    i2cstart        ; Send start condition
	rlf     i2cblk,W        ; Rotate i2cblk left, store in W
	andlw   0Eh             ; Only bits 1-3 is block address        
	iorlw   0A1h            ; Add device address and set RW bit =Read
	call    i2cputb         ; Send control data 
	call    i2cgetb         ; Get data from mem
	movwf	i2cdata		; Store in i2c data register
	call    i2cstop         ; Send stop condition
	return

;**** Random address read
i2crar
	call    i2cstart        ; Send start condition
	rlf     i2cblk,W        ; Rotate i2cblk left, store in W
	andlw   0Eh             ; Only bits 1-3 is block address        
	iorlw   0A0h            ; Add device address RW bit = Write (address)
	call    i2cputb         ; Send control data 
	movf    i2caddr,W 
	call    i2cputb         ; Write address to mem
	call    i2ccar          ; Make a cur. addr. read to get data
	return  

;**** Sequential read, 
; SEQCTRL = 0 -> reads (i2cdata) bytes to copy area (20-2F hex)
; SEQCTRL = 1 -> reads until data = (i2cdata)

i2cseqr
	movlw	C_START		; Start of copy area
	movwf	FSR		; Set file select register to start of copy area
	call    i2cstart        ; Send start condition
	rlf     i2cblk,W        ; Rotate i2cblk left, store in W
	andlw   0Eh             ; Only bits 1-3 is block address        
	iorlw   0A0h            ; Add device address RW bit = Write (address)
	call    i2cputb         ; Send control data 
	movf    i2caddr,W
	call    i2cputb         ; Send address data  
	call    i2cstart        ; Send start condition
	rlf     i2cblk,W        ; Rotate i2cblk left, store in W
	andlw   0Eh             ; Only bits 1-3 is block address        
	iorlw   0A1h            ; Add device address and set RW bit =Read
	call    i2cputb         ; Write address to mem
seqr1	call	i2cgetb		; Get data
	movwf	IADDR		; Copy data to copy area
	incf	i2caddr,F	; Increase address counter
	btfsc	STATUS,Z	; Check if wraparound
	incf	i2cblk,F	; if so, increase block counter
	;**** out of mem control ? ********************************
	incf	FSR,F		; Point to next pos in copy area
	call	checkifend
	btfss	STATUS,Z	; Check if end
	goto	seqr2		; No, continue
	call	i2cstop		; Yes, we're fininshed 
	return
seqr2	call	i2cack		; Send acknowledge
	goto	seqr1



;**** Sequential write
; SEQCTRL = 0 -> writes (i2cdata) bytes to copy area (20-2F hex)
; SEQCTRL = 1 -> writes until data = (i2cdata)
i2cseqw
	call    i2cstart        ; Send start condition
	rlf     i2cblk,W        ; Rotate i2cblk left, store in W
	andlw   0Eh             ; Only bits 1-3 is block address        
	iorlw   0A0h            ; Add device address RW bit = Write (address)
	call    i2cputb         ; Send control data 
	btfsc	errors,I2CACK	; Make sure we got acknowledge
	goto	i2cseqw		; Start over if we didn't, propably unfinished write cycle
	movf    i2caddr,W
	call    i2cputb         ; Send address data  
seqw1	movf	IADDR,W		; Get data
	call	i2cputb		; Write data to mem
	movf	IADDR,W		
	incf	FSR,F		; Point to next data
	call	checkifend
	btfsc	STATUS,Z	; Check if end of data
	goto	seqw3		; If so, send stop and return
	incfsz	i2caddr,F	; Check if block rollover
	goto	seqw2		; No, check if page rollover
	call	i2cstop		; Yes block rollover, send stop
	incf	i2cblk,F	; Increase block address
	btfss	i2cblk,.3	; Test if block overflow = out of mem!!!!
	goto	i2cseqw		; Start sending where we stopped
	bsf	errors,I2CMEM	; OUT OF MEMORY!!!	
	return	
seqw2	movf	i2caddr,W	; Check if lower nibble=0
	andlw	00Fh		; if so, we have page rollover
	btfss	STATUS,Z
	goto	seqw1		; No page rollover, continue
	call	i2cstop		; page rollover, send stop and
	goto	i2cseqw		; start over where we stopped	
seqw3	call	i2cstop		; Send stop
	return

checkifend			; Checks if sequential write is finished
	btfsc	flags,SEQCTRL	; Check type of end condition
	goto	cie1		; Check if data = i2cdata
	decf	i2cdata,F	; Decrease i2cdata 
	return			
cie1	subwf	i2cdata,W	; Check if data = i2cdata
	return


;**** Byte write
i2cbwr
	call    i2cstart        ; Send start condition
	rlf     i2cblk,W        ; Rotate i2cblk left, store in W
	andlw   0Eh             ; Only bits 1-3 is block address        
	iorlw   0A0h            ; Add device address and reset RW bit =Write
	call    i2cputb         ; Send control data 
	btfsc	errors,I2CACK	; Make sure we got acknowledge
	goto	i2cbwr		; Start over if we didn't, probably due to unfinished write cycle
	movf    i2caddr,W 
	call    i2cputb         ; Write address to mem
	movf	i2cdata,W
	call    i2cputb         ; Write data to i2c
	call    i2cstop         ; Send stop condition
	movf	i2caddr,W	; ******* Why this ? ***********************
	return

;****** Low level i2c functions ******

sdaset				; Set selected SDA
	btfss	flags,EE_RTC
	bsf	PORTB,RTCSDA	; If clear, output to RTC
	btfsc	flags,EE_RTC
	bsf	PORTB,EESDA	; If set, output to EEprom
	return

sdarset				; Reset selected SDA
	btfss	flags,EE_RTC
	bcf	PORTB,RTCSDA	; If clear, output to RTC
	btfsc	flags,EE_RTC
	bcf	PORTB,EESDA	; If set, output to EEprom
	return

;**** Read SDA value and store in status carry flag
sdaread
	bcf	STATUS,C
	btfss	flags,EE_RTC
	goto	read_rtc
	btfsc	PORTB,EESDA
	bsf	STATUS,C
	return
read_rtc
	btfsc	PORTB,RTCSDA
	bsf	STATUS,C
	return	

;**** Send start condition
i2cstart        
	pbout
	call	sdaset		; Set SDA high
	bsf     PORTA,SCL       ; Set SCL high
	call    delay8          ; Delays app. 8 us
	call	sdarset		; Set SDA low
	call    delay8
	bcf     PORTA,SCL       ; Set SCL low
	call    delay8
	return

;**** Send stop condition
i2cstop 
	pbout
	bcf     PORTA,SCL       ; Make sure SCL is low
	call	sdarset		; Set SDA low
	call    delay8
	bsf     PORTA,SCL       ; Set SCL high
	call	delay8
	call	sdaset		; Set SDA high
	call    delay8
	bcf	PORTA,SCL	; Set SCL low to avoid unwanted start cond.
	pbin
	return

;**** Send acknowledge
i2cack
	pbout
	bcf     PORTA,SCL       ; Make sure SCL is low
	call	sdarset		; Set SDA low
	call    delay8
	bsf     PORTA,SCL       ; Set SCL high
	call	delay8
	bcf	PORTA,SCL	; Set SCL low
	pbin
	return

;**** Send a byte, fetched from W
i2cputb
	pbout
	movwf	i2ctmp		; Get data into temporary register
	movlw   .8           	; Set w to 8 (bits in a byte)
	movwf   loop            ; Move 8 into the loop register
sndlop  rlf     i2ctmp,F        ; Rotate data left through carry
	call	sdarset		; Set SDA low
	btfsc   STATUS,C        ; Skip next if carry clear
	call	sdaset		; Carry high => set SDA high
	bsf     PORTA,SCL       ; Send clockpulse
	call    delay8
	bcf     PORTA,SCL       ; End of clockpulse
	call    delay8
	decfsz  loop,F          ; Decrease loop, skip next if zero
	goto    sndlop          ; Output next bit
;* Get acknowledge
	pbin                    ; Set SDA as input
	bcf	errors,I2CACK	; Clear acknowledge error bit
	bsf     PORTA,SCL       ; SCL high
	call    delay8          ; Wait a while  
	call	sdaread		; Get SDA data, should be pulled low by slave
	btfsc   STATUS,C	; Skip next if acknowledge ok (=low)
	goto    no_ack          ; No acknowledge received
	bcf     PORTA,SCL       ; Set SCL low
	call    delay8
	return
no_ack  bcf     PORTA,SCL       ; SCL low       
	bsf	errors,I2CACK	; Set bit in errors register
	call	delay8
	return


;**** Read a byte, store in W
i2cgetb
	pbin                    ; Set SDA as input
	movlw   .8              ; Set w to 8 (bits in a byte)
	movwf   loop            ; Move 8 into the loop register
	clrf    i2ctmp          ; Clear data register
rdlop	bcf     STATUS,C        ; Make sure status flag C is reset
	bsf     PORTA,SCL       ; Set clock high
	call	delay8
	rlf     i2ctmp,F        ; Rotate tmp left to make space for next bit
	call	sdaread		; Get SDA data
	btfsc   STATUS,C	; Test if SDA high
	bsf     i2ctmp,.0       ; If so, set bit 0
	bcf     PORTA,SCL       ; Set clock low
	call	delay8
	decfsz  loop,F          ; Decrease loop, skip next if zero
	goto    rdlop           ; Get next bit
	movf	i2ctmp,W	; Return data i W register
	return                  ; We're finished!






