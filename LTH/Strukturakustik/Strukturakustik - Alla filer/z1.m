clear all
%for kl=1:13;
kl=0.2;
l=0.85;
m=0.37;
m0=0.85;
E=200; %Elasticiteten för stål i N/m^2
D=7800; %Densitet för stål i kg/m^3
c=sqrt(E/D);
f=(kl*c)/2*pi*l;
w=2*pi*f;

z11=(m0*c)*cot(kl)/j+j*w*m;
z22=(m0*c)*cot(kl)/j;
z12=(m0*c)/(j*sin(kl));
z21=(m0*c)/(j*sin(kl));


T= [z11/z21 (z11*z22)/(z21)-z12; 1/z21   z22/z21];

F(1)=1;
T=T^9;
Vn=1/T(3);%Beräknar randvillkor
V1=T(4)/T(3);

for i=2:10
F(i)=(V1/T(2)-T(4)/(T(3)*T(2)))/(1-T(4)*T(1)/T(2)*T(3));
end 
figure(1)
n=1:10;
plot(n,F)
xlabel('punktmassa n ---->')
ylabel('Fn')


% 
% 
% 
% g=log(Fn(5)/Fn(1))/-5;
% figure(2)
% gvektor = [2.7931 3.3273 5.2343 4.0080 4.0101 5.1661 4.5713 4.3592 5.1646 5.0081 4.6046 5.1783 5.4240];
% kl=1:13;
% plot(kl,gvektor)
% xlabel('kl---->')
% ylabel('Fn')









    


% F1=1;
% V1=0;
% VL=[F1; V1];
% HL=T4\VL
% F5=HL(1,1);
% V5=HL(2,1);
% g=log((1/F5)^0.2);