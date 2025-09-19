#include <iregdef.h>
#include <idtcpu.h>

#define SWITCHES 0xbf900000
#define LEDS     0xbf900000
#define BUTTONS  0xbfa00000

        .globl start
        .ent start

start:  sub     sp, 4           # Reserve new stack space
        sw      ra, 0(sp)       # Save return address

Loop:   jal     Comp            # Perform heavy computations

        lb      a1, BUTTONS     # Load button port value
        andi    a1, 0x30        # Mask out button indication bits
        beq     a1, zero, Loop  # Loop if no button pressed

        sb      a1, BUTTONS     # Clear latched value
        lb      a0, SWITCHES    # Load switch position
        sb      a0, LEDS        # Output switch position to LEDs
        b       Loop            # Repeat polling loop

                                # Standard program ending, but in
                                # this case, it will never be used
        lw      ra, 0(sp)       # Restore return address
        addi    sp, 4           # Dealloacte stack space
        j       _exit           # Jump to exit routine

        .end start

        .ent Comp

Comp:   li      t0, 0xffffff    # Initialize counter value
Delay:  sub     t0, 1           # Decrease counter by 1
        bne     t0, r0, Delay   # Test if ready
        jr      ra              # Return to polling loop

        .end Comp
