;************************************
;*
;*   RTC Constants

RTC_GO	equ	08h	; Enable clock and mask off year/weekday
RTC_ST	equ	088h	; Disable clock and mask off year/weekday
RTC_AL	equ	080h	; Disable clock and read all

;**** RTC registers
SECONDS	equ	02h
MINUTES	equ	03h
HOURS	equ	04h
DATE	equ	05h
MONTH	equ	06h


;************************************
;*
;*	Real Time Clock functions


;**** Set control/status register in RTC
rtc_init
	bcf	flags,EE_RTC	; Select RTC communication
	movlw	RTC_GO		; Mask off year and weekdays
	movwf	i2cdata
	clrf	i2cblk
	clrf	i2caddr
	call	i2cbwr
	return

;**** Output time to LCD 
get_time
	bcf	flags,EE_RTC	; Select real time clock communication
	clrf	i2cblk
	movlw	SECONDS		; Get RTC address of seconds
	movwf	i2caddr		
	bcf	flags,SEQCTRL	; Set sequential read to  
	movlw	.5		; read 5 sequential bytes
	movwf	i2cdata		; from RTC
	call	i2cseqr		; Read time data
	return			

put_time
	movlw	ROW2		; Set cursor position to second row
	call	lcdcmd
;	movlw	DEC		; Set LCD to decrease position after write
;	call	lcdcmd
	movlw	C_START+3	; Point to date
	movwf	FSR		
	clrf	tmp		
	bsf	tmp,IN_SPCE	; Makes bcd_out insert space instead of leading zeros
	call	bcd_out		; Output date
	incf	FSR,F
	movlw	SLASH		; Write slash
	call	lcdwr
	bsf	tmp,RL_ZERO	; Just remove leading zero
	call	bcd_out		; Output month
	movlw	SPEJS		; Write a space to make sure no old
	call	lcdwr		; char is left behind when going from two to one digit value
	decf	FSR,F
	decf	FSR,F
	movlw	ROW2+TIMEOFF	; Time offset on second row
	call	lcdcmd
	bcf	tmp,RL_ZERO	; Don't remove leading zero but
	bsf	tmp,IN_SPCE	; Insert space instead of leading zero 
	call	bcd_out		; Output hours
	decf	FSR,F
	movlw	COLON		; Write colon
	call	lcdwr
	bcf	tmp,IN_SPCE	; Don't insert space instead of leading zeros
	call	bcd_out		; Output minutes
	decf	FSR,F
	movlw	COLON		; Write colon
	call	lcdwr
	call	bcd_out		; Output seconds
	bcf	flags,RTCINC	; Makes bcd_out remove leading zeros
	return

bcd_out	;**** RTC must be set to 24h mode (AM/PM flag=0) for this to work properly
	swapf	IADDR,W
	andlw	0fh		; Get tens value
	btfss	STATUS,Z	; Is there a leading zero?
	goto	bo0		; No, write the value
	btfsc	tmp,RL_ZERO	; Remove leading zeros?
	goto	bo1		; Yes
	btfss	tmp,IN_SPCE	; Insert space instead of zeros
	goto	bo0		; No, write zero
	movlw	SPEJS		; Yes 
	call	lcdwr		; write space
	goto	bo1		; Now write unit value
bo0	addlw	030h		; Create ASCII code
	call	lcdwr		
bo1	movf	IADDR,W		
	andlw	0fh		; Get unit value
	addlw	030h		; Create ASCII code
	call	lcdwr			
	return

;**** Functions for setting the time
set_time
	movlw	CLEAR		; Clear Display
	call	lcdcmd
	movlw	ROW2+.1		; Set cursor at second position on second row
	movwf	curpos		; Store current cursor position
time0	movlw	CUR_OFF
	call	lcdcmd		; Turn cursor off during output of time
	call	get_time	; Get current time
	call	put_time	; Write it to the display
	movf	curpos,W	; Restore last cursor position
	call	lcdcmd
	movlw	CUR_ON		; Turn cursor on
	call	lcdcmd
	btfsc	errors,B_FIRST	; Is button held down?
	goto	time6		; Yes
;	movlw	.20		; No, this is first lap, delay a while
;	movwf	loop
time9	movlw	.127
	call	delay
;	decfsz	loop,F
;	goto	time9
	bsf	errors,B_FIRST	; Button have been pressed
time6	movlw	.75		; Counts too fast when button held done
	call	delay		; So slow down a bit
time8	call	get_but
	btfss	STATUS,Z	; Check if button pressed
	goto	time7		; Yes 
	bcf	errors,B_FIRST	; Reset if button released
	goto	time8
time7	btfsc	tmp,BUT1	; Move cursor left
	goto	time_left
	btfsc	tmp,BUT2	; Increase value
	goto	time_inc
	btfsc	tmp,BUT3	; Decrease value
	goto	time_dec
	btfsc	tmp,BUT4	; Move cursor right
	goto	time_right
	goto	time0		; No button pressed

;**** Move cursor in some direction
time_left
	movf	curpos,W	; Test if already at first position
	sublw	ROW2+.1
	btfsc	STATUS,Z	; If so,
	goto	time0		; do nothing
	movlw	.3
	subwf	curpos,F	; Decrease position by 3
	movf	curpos,W
	call	lcdcmd		; set new cursor position
	goto	time0	
time_right
	movf	curpos,W	; Test if already at last position
	sublw	ROW2+.10
	btfss	STATUS,Z	; If not,
	goto	time_r		; proceed
	goto	set_year	; else set years after leap
time_r	movlw	.3
	addwf	curpos,F	; Increase position by 3
	movf	curpos,W
	call	lcdcmd		; set new cursor position
	goto	time0	
;**** Increase/decrease time/date
time_inc
	bsf	flags,RTCINC
	goto	time2
time_dec
	bcf	flags,RTCINC
time2	bcf	flags,DATE_F	; Clear date/month select flag
	movlw	RTC_ST		; Stop RTC while setting time
	movwf	i2cdata
	clrf	i2caddr
	call	i2cbwr		; Send stop code
	movf	curpos,W	; Check what to change
	sublw	ROW2+.1		; Date?		
	btfss	STATUS,Z
	goto	time3
	movlw	031h
	movwf	tmp
	movlw	DATE		; Address to date register in RTC
	bsf	flags,DATE_F	; Set date/month select flag
	goto	time_change
time3	movf	curpos,W	; Month?
	sublw	ROW2+.4		
	btfss	STATUS,Z
	goto	time4
	movlw	012h
	movwf	tmp
	movlw	MONTH		; Address to months register in RTC
	bsf	flags,DATE_F	; Set date/month select flag
	goto	time_change
time4	movf	curpos,W	; Hour?
	sublw	ROW2+.7		
	btfss	STATUS,Z
	goto	time5
	movlw	023h
	movwf	tmp		
	movlw	HOURS		; Address to hours register in RTC
	goto	time_change
time5	movf	curpos,W	; Minute?
	sublw	ROW2+.10		
	btfss	STATUS,Z
	goto	time0		; This row should never be executed
	movlw	059h
	movwf	tmp		
	movlw	MINUTES		; Address to minutes register in RTC

time_change
	movwf	i2caddr		; Get address of data in RTC
	call	i2crar		; Get data
	btfss	flags,RTCINC	; Check if increase
	goto	ch_dec
ch_inc
	movf	tmp,W		; Get max value
	subwf	i2cdata,W
	btfss	STATUS,Z	; Check if max value
	goto	tch0		; If not, proceed
	clrf	i2cdata		; else set new value = 0
	btfsc	flags,DATE_F	; or if date/month
	bsf	i2cdata,.0	; set new value = 1
	goto	rtc_store	; and go back
tch0	incf	i2cdata,F	; Increase value
	movlw	0Ah		
	subwf	i2cdata,W
	btfss	STATUS,DC	; Check if unit overflow
	goto	rtc_store	; if not we're finished here
	movlw	0F0h
	andwf	i2cdata,F	; Set low nibble=0
	movlw	010h
	addwf	i2cdata,F	; Increase high nibble
	goto	rtc_store	; and go back
ch_dec
	bcf	STATUS,C	; Clear carry flag
	movf	i2cdata,W	; Check if zero
	btfsc	flags,DATE_F	; If date/month
	sublw	.1		; check if one
	btfss	STATUS,Z	; Make check
	goto	tch2		; If not min value, proceed
	movf	tmp,W
	movwf	i2cdata		; else set max value
	goto	rtc_store	; and go back
tch2	movf	i2cdata,W	; Restore data in W
	andlw	0Fh
	btfss	STATUS,Z	; Check if low nibble = 0
	goto	tch3		; If not, proceed	
	movlw	010h		; else,
	subwf	i2cdata,F	; Decrease high nibble,
	movlw	09h
	addwf	i2cdata,F	; Set low nibble = 9
	goto	rtc_store	; and go back
tch3	decf	i2cdata,F
	goto	rtc_store

rtc_store
	call	i2cbwr		; Store new value
	btfsc	flags,DATE_F	; If time change, clear seconds
	goto	rtc_s1
	clrf	i2cdata
	movlw	SECONDS		; Clear seconds
	movwf	i2caddr
	call	i2cbwr
rtc_s1	movlw	RTC_GO		; Start RTC after setting time
	movwf	i2cdata
	clrf	i2caddr
	call	i2cbwr		; Send start code
	goto	time0	

set_year
	movlw	CLEAR		; Clear Display
	call	lcdcmd
	movlw	ROW2
	call	lcdcmd
	clrf	tmp		; Offset on second row 
	movlw	LEAP
	call	wrtxt		; Write info string	
	movlw	030h		; Set data = 0 (ascii)
	movwf	i2cdata		; Use i2cdata as temporary register
set_y1	movf	i2cdata,W
	call	lcdwr		; Write value to LCD
	movlw	.1
	call	delay		; Delay 1 ms
	movlw	ROW2+LEAP_L	; Set LCD position
	call	lcdcmd
	call	st_prsd
set_y2	call	get_but
	btfsc	STATUS,Z
	goto set_y2
	btfsc	tmp,BUT2
	goto	year_inc
	btfsc	tmp,BUT3
	goto	year_dec
	btfsc	tmp,BUT4
	goto	year_rdy
	goto	set_y2
year_inc
	incf	i2cdata,F
	btfsc	i2cdata,.2	; Check if limit exceeded
	decf	i2cdata,F	; If so, decrease
	goto	set_y1
year_dec
	movf	i2cdata,W
	sublw	030h
	btfss	STATUS,Z	; Check if already zero
	decf	i2cdata,F	; If not, decrease
	goto	set_y1
year_rdy
	rlf	i2cdata,F	; Copy and mask out
	rlf	i2cdata,F	; year data
	swapf	i2cdata,W	; and
	andlw	0C0h		; store in
	movwf	tmp		; tmp register
	clrf	i2caddr
	movlw	RTC_AL		; Stop clock and 
	movwf	i2cdata		; enable read of 
	call	i2cbwr		; year/weekday info
	movlw	DATE
	movwf	i2caddr
	call	i2crar		; Get year/date
	movf	i2cdata,W
	andlw	03Fh		; Mask off year bits
	iorwf	tmp,W		; Merge new year bits 
	movwf	i2cdata
	call	i2cbwr		
	movlw	RTC_GO		; Start RTC after setting year
	movwf	i2cdata
	clrf	i2caddr
	call	i2cbwr		; Send start code
	call	lcdinit
	return			; We are finished



