scale = 20e9;
%------Frekvensen
f = 1000e6;
o = 2*pi*f;
%------Materialets parametrar
u0=4*pi*1e-7;
gamma = 1.759e11;
H_0 = 1;
M_S = 1800/(4*pi);
w_0 = 10e9*2*pi;
w_m = 5.04e9*2*pi;
e = 14;
u = u0*(1+w_0*w_m/(w_0^2-o^2));
k = u0*o*w_m/(w_0^2-o^2);
%------Vågtal
bp = o*sqrt(e*(u+k));
bm = o*sqrt(e*(u-k));
%------Amplitud för LHCP & RHCP
a = e*o/bp;
b = e*o/bm;
N = 377;
Ap = 1e10*(1/(1+bp*N));
Am = 1e10*(1/(1+bm*N));
%------Plattans tjocklek
z = 1e-3;
dz = 5e-5;

%------Polarisationen
for t=1:100
    compass(Ap+Am);
    hold on;
    Ex = (Ap*(exp(i*(bp)*z))+Am*(exp(i*bm*z)))*exp(i*o*t/(scale));
    Ey = (-i*Ap*(exp(i*(bp)*z))+Am*i*(exp(i*(bm)*z)))*exp(i*o*t/(scale));
    %Ex1 = (Ap*(exp(i*(bp)*(z+dz)))+Am*(exp(i*(bm)*(z+dz))))*exp(i*o*t/(1e9));
    %Ey1 = (-i*Ap*(exp(i*(bp)*(z+dz)))+Am*i*(exp(i*(bm)*(z+dz))))*exp(i*o*t/(1e9));

%   Ex = 0.5*cos(2*pi/50*t);
%   Ey = -0.5*cos(2*pi/50*t);
%   Ey = -0.5*sin(2*pi/50*t);
    compass(real(Ex),real(Ey));
%   compass(real(Ex1),real(Ey1));
%   compass(real(Ex));
%   compass(0,real(Ey));
    M(t) = getframe;
    hold off;
    
end

    
