#include <iregdef.h>

.set reorder
.text
.globl start
.ent start

start:	jal		wait
		lui		s0, 0xbf90
		lbu		s1, 0x0(s0)
		nop
		jal		wait
		nop
		lb		s2,	0x0(s0)
		nop
	    divu	s1, s2
		mflo	s3
		b		start
		nop
.end start

.globl wait
.ent wait

wait:	la		t0, 0xbfa00000
L1:		lb		t1, 0x0(t0)
        nop
		andi	t1, t1, 0x1
		beq		t1, zero, L1
		nop
L2:		lb		t1, 0x0(t0)
		nop
		andi	t1, t1, 0x1
		bne		t1, zero, L2
		nop
		jr ra

.end wait