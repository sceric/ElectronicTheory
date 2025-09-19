function main

T = 2*pi;
solinit = bvpinit(linspace(0,2),@guess,T) 
sol = bvp4c(@ode,@bcdeviation,solinit)

T = sol.parameters;
xx = linspace(0,2);
yy = deval(sol,xx);

figure(1);
hold on;
plot(T*xx,yy(1,:));
plot(T*xx, -2*sin(2*pi*xx), 'r');
hold off;

figure(2);
hold on;
plot(T*xx,yy(2,:));
plot(T*xx, cos(2*pi*xx) + 1.0, 'r');
hold off;



%--------------------------------------------------------------------------


% Solving a simple 2pBVP

% y" = f(x)
% y(0) = a, y(1)=b
a = 3;
b = 1;

% Number of internal points
N = 20;
dx = 1/(N+1);
dx2 = dx*dx;

% Grid points including boundary points
xx = linspace(0,1,N+2)';
x = xx(2:N+1);

% Create tridiag(1 -2 1) matrix and divide by dx2
v = zeros(1,N);
v(1) = -2;
v(2) = 1;
T = toeplitz(v);
Th = T/dx2;

% Create right-hand side
f = x.^2 + 3 + sin(x)

% Insert boundary values
f(1) = f(1) - a/dx2
f(N) = f(N) - b/dx2
f
% Solve the problem
y = Th\f;

% In order to plot, insert boundary values
yy = [a; y; b];
figure(3)
plot(xx,yy)

%Övningsuppgift 6.3
figure(4);
N=20;
dx = 1/(N+1);
A=toeplitz([-2 1 zeros(1,N-2)]/dx2);
[V,D]=eig(A);
relerr=abs(D(N,N)-exact)/abs(exact);
xv=linspace(0,1,N+2);
plot(xv,[0,V(:,N);0])