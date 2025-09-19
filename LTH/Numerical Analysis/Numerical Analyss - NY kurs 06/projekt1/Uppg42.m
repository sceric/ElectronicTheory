xpoints=[0.912 0.986 1.060 1.130 1.190 1.260 1.320 1.380 1.410 1.490];
ypoints=[13.7 15.9 18.5 21.3 23.5 27.2 32.7 36.0 38.6 43.7];
logXpoints=log(xpoints);
logYpoints=log(ypoints);
Gradtal = 1;

%bilda matrisen
A=vdm(logXpoints,Gradtal);

%stoppa in i lsq
f=lsq(A,logYpoints);

%Plotta punkterna i ett semi-log diagram
loglog(xpoints,ypoints,'b*')
grid on

hold on
x=linspace(0,3.5,36);

b=f(2)
a=exp(f(1));

%Skapa funktionen med de ovan framtagna koefficienterna
y=a*(x.^b);
%Plotta funktionen
loglog(x,y,'r')
xlabel('height');
ylabel('weight');
title('BMI - logaritmisk skala');