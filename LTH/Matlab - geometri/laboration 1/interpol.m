function [done]=interpol(T,F)
%function=interpol(T,F)
%     Fits a polynomial of degree n to the nodes (T,F), where n+1 is
%     the number of nodes.
n=length(T);
L=T(n)-T(1);
h=L/50;
tt=T(1):h:T(n);
gg=zeros(1,length(tt));
j=1;
for i=tt
  N=neville(T,F,i);
  gg(j)=N(n);
  j=j+1;
end
plot(T,F,'b-',tt,gg,'r--');
axis([T(1) T(n) -1 1]);
grid;
done=1;
