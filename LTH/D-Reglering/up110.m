
A=[-1 0;0 -1]
B=[1;2]
C=[3 4]
D=[0]

Wo=obsv(A,C)
rank(Wo)
Con=ctrb(A,B)
rank(Con)

%system är inte obserbart och inte kontrolbart