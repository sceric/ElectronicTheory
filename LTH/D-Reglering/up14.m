

s=tf('s');
P=1/(s^2+0.6*s+1);
P.InputDelay=1.5
bode(P)
grid;
nyquist(P)
step(P)

