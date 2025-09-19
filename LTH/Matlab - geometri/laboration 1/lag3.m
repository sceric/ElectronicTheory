
T=linspace(-5,5,3);
F=sqrt(25-T.^2);
subplot(3,1,1);
Interpol(T,F);
axis('equal');                    
title('Lagrande interpolation')  



P=linspace(-5,5,3);
F1=sqrt(25-P.^2);
subplot(3,1,2);
splineInterpol(P,F1);
axis('equal');                    
title('B-spline')   




subplot(3,1,3);
b=[-5 0 5; 0 5 0];
bezier(b)
plot(b)
axis('equal');                    
title('Bezier kurva')   






