

function x=vdm(xpoints,degree):
degree=degree+1;
E=ones(length(xpoints),degree)
for k=1:length(xpoints);
    for j=1:degree;         
           A(k,j)=dot(E(k,j),xpoints(1,k))^(j-1);
    end;    
end;
A

