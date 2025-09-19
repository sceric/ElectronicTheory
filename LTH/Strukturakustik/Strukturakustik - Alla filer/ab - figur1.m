figure(2)
w=0:0.001:10;
w1=1;
b=2*asin(w/w1);
plot(w,real(b),'r');
grid

hold on

a=2*acosh(w/w1);
plot(w,real(a));

xlabel('kl----->')
ylabel('a,b----->')
Title('w1=1')