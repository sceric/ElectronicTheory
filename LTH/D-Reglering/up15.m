
A=[0 1;1 0]
B=[1;0]
Wc=ctrb(A,B);
rank(Wc)
p=[1 1.4 1];
L=place(A,B,roots(p))