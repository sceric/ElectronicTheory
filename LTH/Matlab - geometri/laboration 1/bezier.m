function [done]=bezier(b)
%
%
%
X=b(1,:)';
Y=b(2,:)'; 
t=1;
while t<= 32
  U=[];
  W=[];  
  for i=1:t
    [u,l]=casteljau([X(:,i)' ; Y(:,i)'],0.5);
    U=[U u(1,:)' l(1,:)'];
    W=[W u(2,:)' l(2,:)'];
  end
  X=U;
  Y=W;
  t=2*t;
end
X=X(:)';
Y=Y(:)';
plot(X,Y,'b');
hold on;
plot(b(1,:),b(2,:),'r--');
plot(b(1,:),b(2,:),'o');
grid on;
done=1;
%The Stromberg curve.
% b=[0 1 5 9 15 11 8; 0 4 5 2 5 10 8]
