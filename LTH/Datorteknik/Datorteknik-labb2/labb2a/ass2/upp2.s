#include <iregdef.h>

.set reorder
.text
.globl input
.ent input

input:	jal		getchar
		li		t0, 0x7a
		bgtu	v0, t0, print
		li		t0, 0x61
		bltu	v0, t0, print
		li		t0, 0x20
		subu	v0, v0, t0

print:	move	a0, v0
		jal		putchar
		j		input
		
.end input