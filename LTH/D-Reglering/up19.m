
G1=1/((s+1)^3)
pole(G1)
G2=zpk(1/((s+1)^3))
pole(G2)

G3=1/(s^3+2.99*s^2+3*s+1)
pole(G3)
G4=zpk(1/((s+0.99)^3))
pole(G4)

%man kan se att zpk format är bättre en tf format vid
%nummerisk beräkning