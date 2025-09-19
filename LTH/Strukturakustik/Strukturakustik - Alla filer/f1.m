
kl=0:0.1:13;
l=0.85;
m=0.37;
m0=0.85;
g= cos(kl)-(m/(2*m0*l))*(kl).*sin(kl); % g är cosh(g)
plot(kl,g)
grid
xlabel('kl---->')
Ylabel('cosh(g)---->')
Title('l=85,m=0.37,m0=0.85')
