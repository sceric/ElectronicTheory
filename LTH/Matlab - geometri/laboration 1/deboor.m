function [B]=deboor(T,F)
%This functions computes the deBoor points for the cubic spline 
%    interpolation correspondinng to the nodes (T,F).

%First we compute time differences
l=length(T);
H=T(2:l)-T(1:l-1);
H=[0 H 0];

%Computes the entries of the matrix
alpha=H(3:l).*H(3:l)./(H(1:l-2)+H(2:l-1)+H(3:l));
beta=H(3:l).*(H(1:l-2)+H(2:l-1))./(H(1:l-2)+H(2:l-1)+H(3:l)) ...
     +H(2:l-1).*(H(3:l)+H(4:l+1))./(H(2:l-1)+H(3:l)+H(4:l+1));
gamma=H(2:l-1).*H(2:l-1)./(H(2:l-1)+H(3:l)+H(4:l+1));

%Creating the matrix
D=zeros(l);
i=1;
while i<l-1
  D(i+1,i)=alpha(i);
  D(i+1,i+1)=beta(i);
  D(i+1,i+2)=gamma(i);
  i=i+1;
end

D(1,1)=1;
D(l,l)=1;
D;

%Then we create the right hand side of the equation
f=zeros(l,1);
f(1)=F(1);
f(l)=F(l);
f(2:l-1)=F(2:l-1).*(H(2:l-1)+H(3:l));

%Next we solve the system to find the deBoor points
B=D\f;
B=[F(1) B' F(l)]';
