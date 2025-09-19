function [done]=subdivide(k)
%subdivide performs k subdivisions of the Bezier curve given by the control
%    polygon b given below.

%b=[0 4 1 3; 0 3 4 0];
b=[ 0 0 2 4 6 9 10 8 5 6 7 ; 0 1 2 1 0 0 2 3 2.5 1.5 1.5 ];
X=b(1,:)';
Y=b(2,:)'; 
t=1;
while t<= 2^(k-1)
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
