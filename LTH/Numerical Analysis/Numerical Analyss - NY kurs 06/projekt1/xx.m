



degree=input('degree=');
xpoints=input('xpoints=');




degree=degree+1;
E=ones(degree,degree)
for k=1:degree;
    for j=1:degree;         
           A(k,j)=dot(E(k,j),xpoints(1,k))^(j-1);
    end;    
end;
A

%----------------------------
%----------------------------

