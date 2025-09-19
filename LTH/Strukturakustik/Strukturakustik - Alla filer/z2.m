clear all
k=7.01; 
%l=0.85;
m=0.37;
m0=0.85;
E=200; %Elasticiteten för stål i N/m^2
D=7800; %Densitet för stål i kg/m^3
c=sqrt(E/D)
l=[0.9 0.9 0.9 0.85 0.8 0.9 0.8 0.8 0.85];
TN=1;
 
for i=1:9
f=(k*l(i)*c)/2*pi*l(i);
w=2*pi*f;
z11=(m0*c)*cot(k*l(i))/j+j*w*m;
z22=(m0*c)*cot(k*l(i))/j;
z12=(m0*c)/(j*sin(k*l(i)));
z21=(m0*c)/(j*sin(k*l(i)));

T= [z11/z21 (z11*z22)/(z21)-z12; 1/z21   z22/z21];

%Beräknar randvillkor
TN=TN*T; %Tar fram ny matris T9 för en struktur som har 9 punktmassor
if i==1
    T1=TN;
elseif i==2
        T2=TN;
elseif i==3
        T3=TN;
elseif i==4
        T4=TN;
elseif i==5
        T5=TN;
elseif i==6
        T6=TN;
elseif i==7
        T7=TN;
elseif i==8
        T8=TN;
else i==9
        T9=TN;
end
    

end
Vn=1/TN(1,2);
V1=TN(2,2)*Vn;
F(1)=1;

%Beräknar kraften vid de olika punktmassorna
for i=2:10
	%F(i)=(V1/Tn(1,2)-Tn(2,2)*F(1)/(Tn(2,1)*Tn(1,2)))/(1-(Tn(2,2)*Tn(1,1)/Tn(1,2)*Tn(2,1)));
    %X=Tn(i)\[1;V1];
  if i==2
     X=T1\[1;V1];
     F(i)=X(1);
elseif i==3
     X=T2\[1;V1];
     F(i)=X(1);
elseif i==4
     X=T3\[1;V1];
     F(i)=X(1); 
elseif i==5
     X=T4\[1;V1];
     F(i)=X(1);
elseif i==6
     X=T5\[1;V1];
     F(i)=X(1);
elseif i==7
     X=T6\[1;V1];
     F(i)=X(1);
elseif i==8
     X=T7\[1;V1];
     F(i)=X(1);
elseif i==9
     X=T8\[1;V1];
     F(i)=X(1);
else i==10
     X=T9\[1;V1];
     F(i)=X(1);
end
  
end

% %Plottar kraften mot antalet punktmassor
figure(7)

n=0:9;
F;
plot(n,F)

grid
xlabel('n ---->');
ylabel('Fn (eller v)---->');
Title('Rumsberoendet för det ändliga nästan periodiska fallet')
legend('kl=8,0, dvs ett stopband');


 
% gvektor = [2.7931 3.3273 5.2343 4.0080 4.0101 5.1661 4.5713 4.3592 5.1646 5.0081 4.6046 5.1783 5.4240];
