
T=linspace(-5,5,12);
F=sqrt(25-T.^2);
subplot(2,1,1);
Interpol(T,F);
axis('equal');                    % set equal scale on axes per pixel
title('Lagrande interpolation')   % put title



P=linspace(-5,5,12);
F1=sqrt(25-P.^2);
subplot(2,1,2);
splineInterpol(P,F1);
axis('equal');                    % set equal scale on axes per pixel
title('B-spline interpolation')   % put title


B=linspace(-5,5,12);
F1=sqrt(25-B.^2);
subplot(2,1,2);
b=[0 1 -1 0;1 0 0 -1];
bezier(b)
plot(b)
axis('equal');                    % set equal scale on axes per pixel
title('Bezierkurva interpolation')   % put title






