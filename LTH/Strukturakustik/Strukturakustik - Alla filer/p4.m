clear all
l=0.85;
m=0.37;
m0=0.85;
E=200; %Elasticiteten för stål i N/m^2
D=7800; %Densitet för stål i kg/m^3
c=sqrt(E/D);

for kl=1:1256;

f=(kl/100*c)/2*pi*l;
w=2*pi*f;

z11=(m0*c)*cot(kl/100)/j+j*w*m;
z22=(m0*c)*cot(kl/100)/j;
z12=(m0*c)/(j*sin(kl/100));
z21=(m0*c)/(j*sin(kl/100));

T= [z11/z21 (z11*z22)/(z21)-z12; 1/z21   z22/z21];

%Beräknar randvillkor
TN=T^9; %Tar fram ny matris T9 för en struktur som har 9 punktmassor
Vn=1/TN(1,2);
V1=TN(2,2)*Vn;


%Beräknar kraften vid de olika punktmassorna

Tn=T^4;
%F(i)=(V1/Tn(1,2)-Tn(2,2)*F(1)/(Tn(2,1)*Tn(1,2)))/(1-(Tn(2,2)*Tn(1,1)/Tn(1,2)*Tn(2,1)));
X=Tn\[1;V1];
F5(kl)=X(1);
g(kl)=-0.25*log(F5(kl));
a(kl)=real(g(kl));
b(kl)=imag(g(kl));
end

%Plottar kraften mot antalet punktmassor
figure(4)
n=0.01:0.01:12.56;
plot(n,a,'g')
hold on
% b(1:213);                       %Transmission region (signal)
% b(214:314);                     %Attenuation region  
% b(315:455)=-b(315:455)+2*pi;    %Transmission region (negerad signal + 2pi)
% b(456:628)=2*pi;                %Attenuation region
% b(629:726)=b(629:726)+2*pi;     %Transmission region (signal + 2pi)
% b(727:942)=3*pi;                %Attenuation region
% b(943:1015)=-b(943:1015)+4*pi;  %Transmission region (negerad signal + 4pi)
% b(1016:1256)=4*pi;              %Attenuation region
plot(n,b,'r')
grid
xlabel('kl ---->')
ylabel('g')
legend('a = realdel av g' , 'b = imaginärdel av g')

