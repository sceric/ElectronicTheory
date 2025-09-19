clear all
%l=0.85;
m=0.37;
m0=0.85;
E=200; %Elasticiteten för stål i N/m^2
D=7800; %Densitet för stål i kg/m^3
c=sqrt(E/D)
l=[0.9 0.9 0.9 0.85 0.8 0.9 0.8 0.8 0.85];
TN=1;
for k=1:1256;
for i=1:9
    if i==1
      TN=1  
    end
f=(k/100*l(i)*c)/2*pi*l(i);
w=2*pi*f;
z11=(m0*c)*cot(k/100*l(i))/j+j*w*m;
z22=(m0*c)*cot(k/100*l(i))/j;
z12=(m0*c)/(j*sin(k/100*l(i)));
z21=(m0*c)/(j*sin(k/100*l(i)));

T= [z11/z21 (z11*z22)/(z21)-z12; 1/z21 z22/z21];

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

	%F(i)=(V1/Tn(1,2)-Tn(2,2)*F(1)/(Tn(2,1)*Tn(1,2)))/(1-(Tn(2,2)*Tn(1,1)/Tn(1,2)*Tn(2,1)));
    %X=Tn(i)\[1;V1];

X=T4\[1;V1]; 
F5(k)=X(1);
g(k)=-0.25*log(F5(k));
a(k)=real(g(k));
b(k)=imag(g(k));
end
  


%Plottar kraften mot antalet punktmassor
figure(15)
n=0.01:0.01:12.56;
plot(n,a,'g')
hold on
b(1:213);                       %Transmission region (signal)
b(214:314);                     %Attenuation region  
b(315:455)=-b(315:455)+2*pi;    %Transmission region (negerad signal + 2pi)
b(456:628)=2*pi;                %Attenuation region
b(629:726)=b(629:726)+2*pi;     %Transmission region (signal + 2pi)
b(727:942)=3*pi;                %Attenuation region
b(943:1015)=-b(943:1015)+4*pi;  %Transmission region (negerad signal + 4pi)
b(1016:1256)=4*pi;              %Attenuation region
plot(n,b,'r')
grid
xlabel('kl ---->')
ylabel('g')
legend('a = realdel av g' , 'b = imaginärdel av g')
