kl=0.01:0.01:12.56;
l=0.85;
m=0.37;
m0=0.85;
kvot=m/(m0*l)

g=acosh(cos(kl)-(m/(2*m0*l))*(kl).*sin(kl)); %Tar fram g
a=real(g);
b=imag(g); %Vektor med 1256 element
  
%Sätter rätt värde på imaginärdelen av g

% b(1:213);                       %Transmission region (signal)
% b(214:314);                     %Attenuation region  
% b(315:455)=-b(315:455)+2*pi;    %Transmission region (negerad signal + 2pi)
% b(456:628)=2*pi;                %Attenuation region
% b(629:726)=b(629:726)+2*pi;     %Transmission region (signal + 2pi)
% b(727:942)=3*pi;                %Attenuation region
% b(943:1015)=-b(943:1015)+4*pi;  %Transmission region (negerad signal + 4pi)
% b(1016:1256)=4*pi;              %Attenuation region

figure(2)
plot(kl,a,'green'); %Plottar realdelen av g
hold on
plot(kl,b,'red'); %Plottar imaginärdelen av g med de ny värdena
grid
xlabel('kl---->')
ylabel('g---->')
Title('l=0.85, m=0.37, m0=0.85')
legend('a = realdel av g' , 'b = imaginärdel av g');
