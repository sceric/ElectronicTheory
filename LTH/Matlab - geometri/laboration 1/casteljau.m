function [U,L]=casteljau(b,t)
%
%
%

[h,l]=size(b);
U=b(:,1);
L=b(:,l);
while l>1
  b=(1-t)*b(:,1:l-1)+t*b(:,2:l);
  [h,l]=size(b);
  U=[U b(:,1)];
  L=[b(:,l) L];
end
