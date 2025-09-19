height = [0.912 0.986 1.060 1.130 1.190 1.260 1.320 1.380 1.410 1.490]';
weight = [13.7 15.9 18.5 21.3 23.5 27.2 32.7 36.0 38.6 43.7]';

loglog(height, weight, '*')
hold on

log_weight = log(weight);
log_height = log(height);

A = vdm(log_height, 1);
temp = lsq(A, log_weight);
a = exp(temp(1,1));
b = temp(2,1);

ix = linspace(0.9, 1.5)';
iy = a * ix.^b;
loglog(ix, iy, 'r');
hold off

rx = 1.72;
ry = a * rx.^b
