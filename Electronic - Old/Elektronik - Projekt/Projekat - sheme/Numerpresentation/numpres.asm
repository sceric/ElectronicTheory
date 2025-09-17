;*********************************************
;*
;*         Phone number indicator
;*
;*             T. Nilsson  1995
;*
;*               Version  2.1   
;*
;*********************************************


	
	PROCESSOR       16C84



;************ PIC Registers ***********

;**** Page 0
IADDR   equ     0h      
TMR0    equ     1h
PCL     equ     2h
STATUS  equ     3h
FSR     equ     4h      
PORTA   equ     5h
PORTB   equ     6h
EEDATA  equ     8h
EEADR   equ     9h
INTCON  equ     0bh
PCLATH  equ     0ah

;**** Page 1
OPTREG  equ     1h
TRISA   equ     5h
TRISB   equ     6h
EECON1  equ     8h
EECON2  equ     9h

;**** Bits in STATUS register
C       equ     .0
DC      equ     .1
Z       equ     .2
RP0     equ     .5
RP1     equ     .6

;**** Bits in INTCON register
GIE     equ     .7
EEIE    equ     .6
T0IE    equ     .5
INTE    equ     .4
RBIE    equ     .3
T0IF    equ     .2
INTF    equ     .1
RBIF    equ     .0

;**** Bits in OPTREG register
RBPU    equ     .7
INTEDG  equ     .6
RTS     equ     .5
RTE     equ     .4
PSA     equ     .3
PS2     equ     .2
PS1     equ     .1
PS0     equ     .0

;**** Bits in EECON1 register
EEIF    equ     .4
WRERR   equ     .3
WREN    equ     .2
WR      equ     .1
RD      equ     .0

;************ User Registers ************
dcnt1   equ     0ch     ; Delay counter 1
dcnt2   equ     0dh     ; Delay counter 2
tmp     equ     0eh     ; register for temporary storage
loop    equ     0fh     ; register for temporary storage
i2cblk  equ     010h    ; selects i2c memory block
i2caddr equ     011h    ; address in block
i2cdata equ     012h    ; i2c read/write data
flags   equ     013h    ; flags for different things
i2ctmp  equ     014h    ; Used for temporary storage in i2c functions
errors  equ     015h    ; If something goes wrong it's indicated here
int1    equ     016h    ; register used for saving in interrupt function
int2    equ     017h    ; register used for saving in interrupt function
int3    equ     018h    ; register used for saving in interrupt function
inttmp  equ     019h    ; tmp register used in interrupt functions
curpos  equ     01Ah    ; Holds LCD cursor position in rtc functions
endaddr equ     01Bh    ; Address of end of data marker in external EEPRom
endblk  equ     01Ch    ; Block in which end of data marker resides
curnum	equ     01Dh	; Number to which pointers are currently pointing
totnum  equ     01Eh	; Total number of numbers stored in database
;       equ     01Fh

;* Register positions 20-2F hex are reserved as copy area

;**** Bits in flags register
EE_RTC  equ     .0      ; I2C select, set=talk to EEprom, reset=talk to RTC
SEQCTRL equ     .1      ; Selects what type of I2C sequential R/W operation to do
RTCINC  equ     .2      ; Used by real time clock setting function, and bcd_out
DATE_F  equ     .3      ; Used by real time clock setting function
DTMF_IN equ     .4      ; Set at incomming call
DTMF_CD equ     .5      ; Set if incoming DTMF data is information code
DTMF_RD equ     .6      ; Set if call has been relayed
DTMF_ST equ     .7      ; Set when stop code received

;**** Bits in tmp register when used as temporary flag register
RL_ZERO	equ	.0	; Remove leading zero when writing bcd to display
IN_SPCE	equ	.1	; Insert space instead of leading zero when writing bcd to display

;**** Bits in errors register
I2CACK  equ     .0      ; No acknowledge from I2C received
I2CMEM  equ     .1      ; Out of memory while write
;** I'm out of flags space, so the flags below are not errors!!!
B_FIRST	equ	.2	; To check if button held down when setting time


;**** Constants
C_START equ     020h    ; Points to beginning of copy area
EODB    equ     07Ch    ; Value of End Of DataBase marker (bar | )
NDSEP   equ     07Bh    ; Value of Number/Date SEParator (left bracket { )
EONR    equ     07Dh    ; Value of end of NumbeR marker (right bracket } )
RELAYED equ     07Eh    ; Value of relayed call mark (right arrow)
RELEND  equ     021h    ; Value of relayed call end mark (exclamation mark)
SPEJS	equ	020h	; ASCII value for space
SLASH	equ	02Fh	; ASCII value for slash
COLON	equ	03Ah	; ASCII value for colon
TIMEOFF	equ	06h	; Offset to time output position

;**** Port A bit definitions
LCDEN   equ     .0      ; LCD Enable
LCDRS   equ     .1      ; LCD Register select, same as E2SDA
DBEN    equ     .2      ; DTMF and Buttons Enable
SCL     equ     .3      ; External I2C EEPROM Clock
StD     equ     .4      ; DTMF signal waiting to be read

;**** Port B bit definitions
RTCSDA  equ     .0      ; Realtimeclock serial data
EESDA   equ     .1      ; EEPROM serial data
RxD     equ     .2      ; RS232 receive data
BUT1    equ     .4      ; Button 1
BUT2    equ     .5      ; Button 2
BUT3    equ     .6      ; Button 3
BUT4    equ     .7      ; Button 4

;**** LCD commands and constants
CLEAR   equ     01h     ; Clears LCD 
HOME    equ     02h     ; Cursor home, returns display shift to home pos.
ROW1	equ	080h	; Set cursor att beginning of row 1
ROW2    equ     0c0h    ; Set cursor att beginning of row 2
DEC     equ     04h     ; Decrease position, freeze display
DECSH   equ     05h     ; Decrease position, shift display
INC     equ     06h     ; Increase position, freeze display
INCSH   equ     07h     ; Increase position, shift display
LCDOFF  equ     08h     ; Turn off LCD
LCDON   equ     0ch     ; Turn on LCD, no cursor
CUR_ON  equ     0eh     ; Turn cursor on
CUR_OFF equ     0ch     ; Turn cursor off
LEFT    equ     018h    ; Scroll display left
RIGHT   equ     01ch    ; Scroll display right
TYPE    equ     038h    ; Type of display, 8 bit data, 2 rows
LCD_L   equ     .16     ; Number of chars/line

;**** Pointers to strings in internal EEProm
; Addr. 0 in internal EEPROM used as a call counter
LEAP    equ     00h     ; RTC leap year setting text
LEAP_L  equ     0Eh     ; 14 bytes long string
ERASE   equ     0Fh	; Really erase question
ERASE_L	equ	08h	; Length of question
YN_L	equ	0Fh	; Length of Yes No text
NONUMB  equ     028h    ; No numbers text
DOR_L	equ	0Ah	; First row is 10 chars long
NON_L	equ	0Ch	; Second row is 12 chars long	

;*****************************************************
;*
;*              Macros

page0   macro   ; Macro to select page 0
	;bcf     STATUS,RP1
	bcf     STATUS,RP0
	endm

page1   macro   ; Macro to select page 1
	;bcf     STATUS,RP1
	bsf     STATUS,RP0
	endm

pbin    macro   ; Setup Port B as all inputs
	page1
	clrf    TRISB           ; Set TRISB = FF hex without
	comf    TRISB,F         ; destroying data in W
	page0
	endm

pbout   macro   ; Setup Port B as all outputs
	page1   
	clrf    TRISB
	page0
	endm

eeread  macro
	page1
	bsf     EECON1,RD       ; Initiate read from internal EEPROM
	page0
	endm

eewrite macro
	page1
	bcf     EECON1,EEIF
	bsf     EECON1,WREN
	movlw   055h
	movwf   EECON2
	movlw   0AAh
	movwf   EECON2
	bsf     EECON1,WR       ; Initiate write to internal EEPROM
	bcf     EECON1,WREN
	page0
	endm


incbcd	macro	count		; Increase BCD value
	movf	count,W
	andlw	0Fh		; Test if lower nibble
	xorlw	09h		; equals 9
	btfsc	STATUS,Z
	movlw	07h		; If so, add 7 to increase high nibble and reset low
	btfss	STATUS,Z
	movlw	01h		; else add one to increase low nibble
	addwf	count,F
	endm
	
decbcd	macro	count		; Decrease BCD value
	movf	count,W
	andlw	0Fh		; Check if lower nibble equals zero
	btfsc	STATUS,Z	
	movlw	07h		; If so, subtract 7 to decrease high nibble and set low to 9
	btfss	STATUS,Z
	movlw	01h		; else decrease low nibble
	subwf	count,F
	endm

;**** End of macros


;***************************************
;*
;*       Start of Program code

	org     0
	goto    start           ; 16C84 Reset vector

	org     4
	goto    interrupt       ; Interrupt vector

	org     5               ; Start of code

	include dtmf.inc
	include i2c.inc
	include rtc.inc
	include database.inc

;****************************************
;*
;*    Initializes ports
portinit
	page1
	clrf    TRISA   
	bsf     TRISA,StD       ; StD is always input, rest is out
	bcf     OPTREG,.7       ; Use internal pullups for port b
	page0
	movlw   04h             
	movwf   PORTA           ; Set DBEN high, rest low
	pbin                    ; Set port b as input
	return


;****************************************
;*
;* Delay loop, delays approx. W ms. W < 128
;*                                  
;* 1+(dcnt1-1)*7+8+dcnt1*((dcnt2-1)*3+4)
;*  Something is strange here  ********************************************

delay   movwf   dcnt1           ; Store W in delay counter
	bcf     STATUS,C        ; Reset Carry bit 
	rlf     dcnt1,F         ; Rotate left = double value in dcnt1   
;	rlf	dcnt1,F		; Seems to be needed to get the right delay, this is the strange part
				; or maybe it isn't, maybe I was wrong
delay1  movlw   093h    ; 3.579 MHz clock => 1.118 us/instr. =>       
	movwf   dcnt2   ; 894.75 instr./ms, 9+(dcnt2-1)*3+4=894.7 =>  
	goto    delay2  ; dcnt2 = 294. but dcnt2 < 256, so set        
delay3  decfsz  dcnt1,F ; dcnt2 = 147 (294/2) and double dcnt1            
	goto    delay1
	return

;* delay=(dcnt2-1)*3+4        
delay2  decfsz  dcnt2,F
	goto    delay2
	goto    delay3

;**** Delays app. 8 us, including call and return
delay8
	nop
	nop
	nop
	nop
	return          


;*************************************
;*
;*       LCD Functions

;**** Write data to LCD
lcdwr
	pbout                   ; Set port b as output
	bsf     PORTA,DBEN      ; Make sure DTMF and Buttons are disabled
	bsf     PORTA,LCDRS     ; Tell lcd data is coming
	movwf   PORTB           ; Write data to port
	bsf     PORTA,LCDEN     ; Enable LCD
	call    delay8          ; Delay 8 us
	bcf     PORTA,LCDEN     ; Disable LCD   
	call    delay8
	call    delay8
	pbin
	return

;**** Write command to LCD
lcdcmd
	pbout
	bcf     PORTA,LCDRS     ; Tell lcd command is coming
	movwf   PORTB           ; Write command to port
	bsf     PORTA,DBEN      ; Make sure DTMF and Buttons disabled   
	bsf     PORTA,LCDEN     ; Enable LCD
	call    delay8
	bcf     PORTA,LCDEN     ; Disable LCD
	movlw   .10               
	call    delay           ; Wait 10 ms    
	pbin
	return
	
;**** Initializes LCD display
lcdinit 
	movlw   CLEAR           ; Clear display
	call    lcdcmd
	movlw   LCDON           ; Turn on display
	call    lcdcmd
	movlw   TYPE            ; Write type to display
	call    lcdcmd
;       movlw   .10             ***********************************
;       call    delay           ***********************************
	return


;****************************************
;*
;*    Text write functions

;**** Write text in internal EEPROM to LCD
; Cursor position must be set before calling
; Cursor position on second row (if 2 rows) is held in tmp
wrtxt
	movwf   EEADR           ; move addr of text to EEADR
wrtxt1  eeread                  ; Initiate read
	movf    EEDATA,W        ; move data to W
	btfsc   STATUS,Z        ; If zero, we're finished
	return
	sublw   01h             ; If 01h => newline
	btfsc   STATUS,Z
	goto    wrtxt3
	movf    EEDATA,W
	call    lcdwr
wrtxt2  incf    EEADR,F         ; increase EEADR
	goto    wrtxt1          ; next char
wrtxt3  movlw   ROW2
	addwf	tmp,W		; Add offset
	call    lcdcmd
	goto    wrtxt2


;**** Write text from copy area to lcd
putlcd
	movlw   C_START         ; Start of copy area
	movwf   FSR             ; Set file select register to start of copy area
	bsf     PORTA,LCDRS     ; We want to send data to LCD
pl1     movf    IADDR,W         ; Move data to W  
	btfsc   STATUS,Z        ; Check if zero
	return                  ; if so, we're finished
	call    lcdwr           ; Output char to display
	incf    FSR,F           ; Next character
	goto    pl1     

;**** Write text from I2C to display
;i2clcd
;       call    i2crar          ; Make a random address read
;il1     movf    i2cdata,W       ; Move I2C data to W  
;       btfsc   STATUS,Z        ; Check if zero
;       return                  ; if so, we're finished
;       bsf     PORTA,LCDRS     ; We want to send data to LCD
;       call    lcdwr           ; Output char to display
;       call    i2ccar          ; Make a current address read
;       goto    il1             ; Next character
;
;geti2c         ;*********************** test function ******************
;       movlw   CLEAR
;       call    lcdcmd
;       clrf    i2cblk
;       movlw   0
;       movwf   i2caddr
;       bsf     flags,EE_RTC
;       call    i2clcd
;       return


;****************************************
;*
;*  Button test functions

;*  Check if button pressed
get_but
	bcf     PORTA,LCDEN     ; Make sure LCD enable is low
	bcf     PORTA,DBEN      ; Enable DTMF and Buttons
	call    delay8          ; Wait a while 
	movf    PORTB,W         ; Get data from PORTB
	bsf     PORTA,DBEN      ; Disable DTMF and Buttons
	iorlw   0Fh             ; Set bits 0-3  
	movwf   tmp             ; store in register
	comf    tmp,F           ; Complement register => 1=button pressed
	return

;* Wait until all buttons released
st_prsd         
	call    get_but
	movf    tmp,F
	btfsc   STATUS,Z
	return
	movlw   .20             ; Delay some ms to
	call    delay           ; avoid bounce
	goto    st_prsd
	

;****************************
;*
;*  Stuff to do when a new call has arrived
newnum
	movf	totnum,W
	addlw	01h		; Add one since since getprev subtracts one
	movwf	curnum		; Set current number counter to correct value
	call	getprev
	call	shownext
	bcf	flags,DTMF_ST	; Reset stop flag
	goto	mainloop

;****************************
;*
;*     Main loop

start
	clrf    flags           ; Clear flags register
	call    portinit        ; Initialize ports
	call    int_init        ; Initialize interrupt
	call    lcdinit         ; Initialize LCD (and port B)
	call    rtc_init        ; Initialize Real Time Clock
	call    get_end         ; Get pointer to end of database

	call    get_but
	btfsc   tmp,BUT1        ; If button 1 pressed at startup
	call    set_time        ; then enter set time routine

;Show first number in database
showfirst
	clrf	curnum
	incbcd	curnum		; Set current number counter to one	
	call    isempty         ; Check if database empty
	btfsc   STATUS,Z
	goto    sf1
	clrf    i2caddr         ; No, show first number in database
	clrf    i2cblk
	call    shownext
	goto    mainloop
sf1     call    lcdinit         
	movlw	ROW1+(LCD_L/2-DOR_L/2) ; Put text in middle of display
	call	lcdcmd			
	movlw	LCD_L/2-NON_L/2	; Center second row
	movwf	tmp
	movlw   NONUMB
	call    wrtxt           ; Write No numbers text to display


mainloop
	btfsc	flags,DTMF_ST	; Check if new number
	goto	newnum

	;Check buttons
	call    get_but         
	btfsc   STATUS,Z        ; Wait until button pressed
	goto    mainloop

	btfss   tmp,BUT1        ; If button 1 pressed
	goto	BUT_2
	call	erasenum	; Erase number
	goto	BUT_END

BUT_2	btfss   tmp,BUT2        ; If button 2 pressed
	goto 	BUT_3
	call	showprev	; Show previous number in list
	goto	BUT_END

BUT_3	btfss   tmp,BUT3        ; If button 3 pressed
	goto	BUT_4
	call	shownext	; Show next number in list
	goto 	BUT_END

BUT_4	btfsc   tmp,BUT4        ; If button 4 pressed
				; Do something

BUT_END	call    st_prsd
	goto    mainloop        ; Start all over again


;****************************
;*
;*    EEPROM Data
;* Value 00h = end of string
;*       01h = newline

	org     02100h
	DE      "Sista skottar:", 00
	DE      "Radera ?", 01
        DE      "    Ja  Nej Tïm", 00
        DE      "Doris V2.2", 01
	DE	"Inga Nummer", 00 
END







