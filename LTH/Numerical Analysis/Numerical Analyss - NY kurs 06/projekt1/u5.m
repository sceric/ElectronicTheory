ar = [1800 1850 1900 2000];
co2 = [280 283 291 370]';
tid = ar;

% axis([0, 20e40, 275, 375]);
hold on

plot(tid, co2, 'o');
A = vdm(tid, 3)
c = lsq(A, co2)

% xx = linspace(0, 20e40);
AA = vdm(xx, 3)
yy = AA * c
% plot(xx, yy, 'r');


hold off