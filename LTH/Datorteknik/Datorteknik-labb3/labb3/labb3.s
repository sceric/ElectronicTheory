# Laboratory Exercise 3, Home Assignment 1
        # Written by Jan Eric Larsson, 5 November 1998

#include <iregdef.h>

        .data
        .align 2
        .globl Test

Test:   .word 1
        .word 3
        .word 5
        .word 7
        .word 9
        .word 8
        .word 6
        .word 4
        .word 2
        .word 0

TextA:  .asciiz "Lab 3, Home Assigment 1\n"
TextB:  .asciiz "The max is %d\n"
TextC:  .asciiz "Done\n"

        .text
        .align 2
        .globl FindMax
        .ent FindMax

FindMax:
        subu    sp, sp, 8   # Reserve a new 8 byte stack frame
        sw      s0, 0(sp)   # Save value of s0 on the stack
        sw      s1, 4(sp)   # Save value of s1 on the stack

        addi	s0,	zero,1	#i=1
        move 	t0,	a0		#t0=adress till vektorn
        lw		s1,	0(t0)	#s1=första värde i vektor
		addi	t3,	zero,10	#t3=10
			
L1:		bge 	s0,	t3,	L2	#om i>=10 slut
		addi	t0,	t0,	4	#t0=adress till vektor[i]
		lw		t1,	0(t0)	#s1=vektor[i]
		addi	s0,	s0,	1
		bge		s1,	t1,	L1
		move	s1,	t1
		b		L1
		
L2:		move	v0,s1	
        
        lw      s1, 4(sp)   # Restore old value of s1
        lw      s0, 0(sp)   # Restore old value of s0
        addu    sp, sp, 8   # Pop the stack frame
        jr      ra          # Jump back to calling routine

        .end FindMax

        .text
        .align 2
        .globl start
        .ent start

start:  subu    sp, sp, 32  # Reserve a new 32 byte stack frame
        sw      ra, 20(sp)  # Save old value of return address
        sw      fp, 16(sp)  # Save old value of frame pointer
        addu    fp, sp, 28  # Set up new frame pointer

        la      a0, TextA   # Load address to welcome text
        jal     printf      # Call printf to print welcome text

        la      a0, Test    # Load address to vector
        jal     FindMax     # Call FindMax subroutine

        la      a0, TextB   # Load address to result text
        move    a1, v0      # Move result to second register
        jal     printf      # Call printf to print result text

        la      a0, TextC   # Load address to goodbye text
        jal     printf      # Call printf to print goodbye text

        lw      fp, 16(sp)  # Restore old frame pointer
        lw      ra, 20(sp)  # Restore old return address
        addu    sp, sp, 32  # Pop stack frame
        j       _exit       # Jump to exit routine

        .end start