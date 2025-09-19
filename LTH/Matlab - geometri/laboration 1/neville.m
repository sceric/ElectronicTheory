function [N]=neville(T,F,t);
%function [N]=neville(T,F,t)
%    neville computes the upper row in a Neville-scheme corresponding
%    to the nodes (T,F) and the abscissa t.
N=F;
n=length(F);
Tau=t*ones(1,n);
for i=2:n
 N(i:n)=(N(i:n).*(Tau(i:n)-T(1:n-i+1))+N(i-1:n-1).*(T(i:n)-Tau(i:n)))./...
        (T(i:n)-T(1:n-i+1));
end
