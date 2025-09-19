
A=[0 1;1 0];
B=[1;0];
C=[0 1];
D=[0];

sys=ss(A,B,C,D);
tf(sys)
