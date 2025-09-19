scale = 70e9;
%------Frekvensen
f = 2450e6;
o = 2*pi*f;
k0 = 2*pi/(3e8/f);
%------Materialets parametrar
u0=4*pi*1e-7;
gamma = 1.759e11;
H_0 = 1;
M_S = 1800/(4*pi);
w_0 = 2*pi*5*1e9;
w_m = 1e9*2*pi;
e = 14;
u = u0*(1+w_0*w_m/(w_0^2-o^2));
k = u0*o*w_m/(w_0^2-o^2);
%------Vågtal
bp = o*sqrt(e*(u+k));
bm = o*sqrt(e*(u-k));
%------Amplitud för LHCP & RHCP
E0 = 1;
a = e*o/bp;
b = e*o/bm;
N = 377;
%------Plattans tjocklek
d = 4e-4;
%dz = 5e-5;
%------Exponenter
X = exp(-i*bp*d);
Y = exp(-i*bm*d);
Z = exp(i*bp*d);
V = exp(i*bm*d);
W = exp(i*k0*d);
%------Amplituden i den reflekterade vågen i x-led.
R1 = -E0+Z*(1+N*a)*E0/(Z*(1+N*a)^2-X*(N*a-1)^2)...
    +V*(1+N*b)*E0/(V*(1+N*b)^2-Y*(1-N*b)^2)+X*(N*a-1)...
    *E0/(Z*(1+N*a)^2-X*(N*a-1)^2)+Y*(1-N*b)*E0/(Y*(1-N*b)^2-V*(1+N*b)^2);
%------Amplituden i den reflekterade vågen i y-led.
R2 = i*(-Z*(1+N*a)*E0/(Z*(1+N*a)^2-X*(N*a-1)^2)...
    +V*(1+N*b)*E0/(V*(1+N*b)^2-Y*(1-N*b)^2)-X*(N*a-1)...
    *E0/(Z*(1+N*a)^2-X*(N*a-1)^2)+Y*(1-N*b)*E0/(Y*(1-N*b)^2-V*(1+N*b)^2));
%------Amplituden för LHCP vågen inuti ferriplattan med riktning +z.
alpha1 = E0*Z*(1+N*a)/(Z*(1+N*a)^2-X*(N*a-1)^2);
%------Amplituden för RHCP ferrivågen riktad längs +z.
alpha2 = V*(1+N*b)*E0/(V*(1+N*b)^2-Y*(1-N*b)^2);
%------Amplituden för LHCP vågen i ferriplattan i -z.
Gamma1 = X*(N*a-1)*E0/(Z*(1+N*a)^2-X*(N*a-1)^2);
%------Amplituden för RHCP vågen i ferriplattan i -z.
Gamma2 = Y*(1-N*b)*E0/(Y*(1-N*b)^2-V*(1+N*b)^2);
%------Amplituden på den transmitterade RHCP vågen.
T1= N*W*(b*Y*V*(1+N*b)*E0/(V*(1+N*b)^2-Y*(1-N*b)^2)...
         -b*V*Y*(1-N*b)*E0/(Y*(1-N*b)^2-V*(1+N*b)^2));
%------Amplituden på den transmitterade LHCP vågen.
 T2= W*(Z*(1+N*a)*E0*X/(Z*(1+N*a)^2-X*(N*a-1)^2)...
          +X*(N*a-1)*E0*Z/(Z*(1+N*a)^2-X*(N*a-1)^2));    
Lang = abs(2*(abs(T1)+abs(T2)));
%figure(1);
%------Polarisationen
for t=1:45
    compass(Lang);

    hold on;
    Ex = (T1+T2)*exp(i*o*t/(scale));
    Ey = i*(-T1+T2)*exp(i*o*t/(scale));
    %Ex1 = (Ap*(exp(i*(bp)*(z+dz)))+Am*(exp(i*(bm)*(z+dz))))*exp(i*o*t/(1e9));
    %Ey1 = (-i*Ap*(exp(i*(bp)*(z+dz)))+Am*i*(exp(i*(bm)*(z+dz))))*exp(i*o*t/(1e9));

%   Ex = 0.5*cos(2*pi/50*t);
%   Ey = -0.5*cos(2*pi/50*t);
%   Ey = -0.5*sin(2*pi/50*t);
    compass(real(Ex),real(Ey));
%   compass(real(Ex1),real(Ey1));
   compass(real(Ex));
   compass(0,real(Ey));
    M(t) = getframe;
    hold off;
    
end





