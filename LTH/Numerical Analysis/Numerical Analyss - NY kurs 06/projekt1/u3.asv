trans = [2250 2500 5000 29000 120000 275000 1180000 3100000 7500000 24000000 42000000 220000000 410000000]';
real_t = [1971 1972 1974 1978 1982 1985 1989 1993 1997 1999 2000 2002 2003]';
t = real_t - 1970;

semilogy(t, trans, '*')
hold on 

log_trans = log(trans);
A = vdm(t, 1);
temp = lsq(A, log_trans);
k = exp(temp(1,1));
c = temp(2,1);

ix = linspace(0, 35)';
iy = k* exp(c*ix);
semilogy(ix, iy, 'r');

hold off