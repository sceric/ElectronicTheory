A=[0 1;1 0]
B=[1;0]
Wc=ctrb(A,B);
rank(Wc)
p=[1 1.4 1];
L=place(A,B,roots(p));
s=tf('s');
P=1/(s^2+0.6*s+1);

bode(P)
grid;
nyquist(P)
step(P)
C=0.5*(1+4*s);
margin(C*P);
CLSYS=feedback(C*P,1)
CLSYS=minreal(C*P/(1+C*P))
