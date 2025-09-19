kl=0:0.1:13;
l=0.85;
m=0.37;
m0=0.85;

figure(1)
chg=cos(kl)-(m/(2*m0*l))*(kl).*sin(kl); %Tar fram cosh(g)
plot(kl,chg,'red') %plottar cosh(g)
grid
xlabel('kl---->')
ylabel('cosh(g)---->')
Title('l=0.85, m=0.37, m0=0.85')


