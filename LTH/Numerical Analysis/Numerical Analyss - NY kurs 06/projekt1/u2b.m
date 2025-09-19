x = [1 2 4]';
y = [2.5 4.5 9]';
A = vdm(x, 2);
c = lsq(A, y);

axis([0.5, 4.5, 1, 10])
hold on
plot(x, y, '*');

ix = linspace(0, 5)';
iA = vdm(ix, 2);
iy = iA * c;
plot(ix, iy, 'k');

rx = 3;
rA = vdm(rx, 2);
res = rA * c

hold off