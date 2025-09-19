
A=[0 1;1 0];
B=[1;0];
C=[0 1];
D=[0];

sys=ss(A,B,C,D);
tf(sys)

[z,p,k]=zpkdata(sys,'v')

P=tf(1,[2 1]);
s=tf('s');
P=1/(2*s+1);
P.InputDelay=0.5;
get(P);
