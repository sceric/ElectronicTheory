function [d]=splineinterpol(T,F)
%splineinterpol(T,F) computes and draws the cubic spline interpolation
%    to the nodes (T,F).

dF=deboor(T,F);
dT=deboor(T,T);

l=length(T);

h=(T(l)-T(1))/(10*(l+3));
W=T(1):h:T(l);
U=[];
for i=W
  U=[U bspline(T,4,i)];
end
plot(dT'*U,dF'*U);
grid on;
d=1;
