function [N]=bspline(G,k,t)
%Function N=bspline(T,t)
%    Given the grid G, the order k of the spline, and a real number t,
%    bspline returns a column vector containing the values of the
%    B-spline basis at the point t; N_ik(t).

%First we find the virtual grid T:
ll=length(G);
T=[G(1)*ones(1,k-1) G G(ll)*ones(1,k-1)];
l=length(T);

%Computes the characteristic functions N_i1() at the point t.
N=zeros(1,l-1);
i=1;
while i<=l-k & T(i) <= t
  i=i+1;
end

if i>1 & i<=l
  N(i-1)=1;
end
  

%Computes the values of the B-spline basis functions N_ik() at the
%point t.

s=t*ones(1,l-1);

for i=1:k-1
  H=T(i+1:l)-T(1:l-i);
  z=find(H==0);
  H(z)=ones(1,length(z));
  
  N(1:l-i-1)=N(1:l-i-1).*(s(1:l-i-1)-T(1:l-i-1))./H(1:l-i-1) ...
             +N(2:l-i).*(T(i+2:l)-s(i+1:l-1))./H(2:l-i); 
end

N=N(1:l-k)';


