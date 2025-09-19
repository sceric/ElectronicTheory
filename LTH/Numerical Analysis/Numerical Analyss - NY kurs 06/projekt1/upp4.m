
%Problem 4

%---------------------------------------------
%---------------------------------------------
%---------------------------------------------
%--------------BMI - linjär skala-------------

hogt=[0.912 0.986 1.060 1.130 1.190 1.260 1.320 1.380 1.410 1.490];
vikt=[13.7 15.9 18.5 21.3 23.5 27.2 32.7 36.0 38.6 43.7]';
logX=log(hogt);
logY=log(vikt);


%bilda matrisen
A=vdm(logX,1); %bildar Vandermond matris
c=lsq(A,logY);  
plot(hogt,vikt,'o') %plotta punkterna
hold on
x=linspace(0,2,20);

beta=c(2)   % berekna beta koefficient
a=exp(c(1));
y=a*(x.^beta); %skapa funktion
%plot(x,y,'r')%%plota linjär skala


%---------------------------------------------
%---------------------------------------------
%---------------------------------------------
%--------------BMI - log-log skala-------------

A=vdm(logX,1);


c=lsq(A,logY);


loglog(hogt,vikt,'o') %plotta punkterna


hold on
x=linspace(0,2,36);

beta=c(2)
a=exp(c(1));
y=a*(x.^beta); %skapa funktion

loglog(x,y,'r') %plota log-log skala
xlabel('height');
ylabel('weight');
title('BMI - logaritmisk skala');