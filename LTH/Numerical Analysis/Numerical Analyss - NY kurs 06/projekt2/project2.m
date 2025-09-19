N = 100;
options = bvpset('RelTol', 1e-5, 'Stats', 'on');
solinit = bvpinit(linspace(0,1,N)',@guess, 2*pi);
sol = bvp4c(@ode, @bcdeviation, solinit,options);
T = sol.parameters
t = T*sol.x;
y = sol.y;
t2 = [t t+T];
y2 = [y y];
y21 = y2(1,:);
y22 = y2(2,:);
plot(t2,y21,'*');
hold
yy = guess(linspace(0,2,200));
yy1 = yy(1,:);
yy2 = yy(2,:);
xkord = T*linspace(0,2,200);
plot(xkord,yy1);
figure
plot(t2,y22,'o');
hold
plot(xkord,yy2);
figure
plot(y(1,:),y(2,:));