# Laboratory Exercise 3, Home Assignment 1
        # Written by Jan Eric Larsson, 5 November 1998

#include <iregdef.h>

     
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
