


P=linspace(-5,5,12);
F1=sqrt(25-P.^2);
splineInterpol(P,F1);
axis('equal');                    % set equal scale on axes per pixel
title('B-spline interpolation')   % put title



