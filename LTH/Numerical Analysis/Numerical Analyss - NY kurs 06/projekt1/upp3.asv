
%Uppgift 3

%--------------------------------------------------
%--------------------------------------------------
%---------------------data-------------------------

trans = [2250 2500 5000 29000 120000 275000 1180000
         3100000 7500000 24000000 42000000 220000000 410000000]';

tid = [1971 1972 1974 1978 1982 1985 1989 1993 1997 1999 2000 2002 2003];

%--------------------------------------------------
%--------------------------------------------------

t = tid - 1970;

semilogy(t, trans, 'o')    %plåta värderna, samam plot som plot()
hold on                    %men logaritamsk skala (bas 10) i y-axel

logTrans = log(trans);     %lagaritam av "trans" vektor
A = vdm(t, 1);              %OBS! t är en radvektor
tt = lsq(A, logTrans);     %tt är vektor
k = exp(tt(1,1))            %beräkna variabel k
c = tt(2,1)                 %beräkna variabel c

xx = linspace(0, 35)';
yy = k* exp(c*xx);          %funktion 
semilogy(xx, yy, 'r');      %plåta funktion

hold off

%--------------------------------------------------
%--------------------------------------------------
y0 = k* exp(c*0)
y15 = k* exp(c*1.5 )
y3 = k* exp(c*3)
y45= k* exp(c*4.5)
y6 = k* exp(c*6 )
y75= k* exp(c*7.5)

x0=2*y0
x15=2*y15
x3=2*y3
x45=2*y45
x6=2*y6
x75=2*y75

tid0=(log(x0/k))/c
tid15=(log(x15/k))/c
tid3=(log(x3/k))/c
tid45=(log(x45/k))/c
tid6=(log(x6/k))/c
tid75=(log(x75/k))/c