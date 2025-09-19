


% _________________________________
%  
%     FIXA DIFFERENTAL EKVATION
% _________________________________

function dydx=ode(x,y,T);       

dydx = zeros(2,1);  % a column vector
dy1 = 3*T*(y(1)+y(2)-((y(1)^3)/3)-1.3); %dif.ekvation 1
dy2 = -(T/3)*(y(1)-0.7+0.8*y(2)); %dif.ekvation 2
dydx=[dy1;dy2];  % dydx - column vector


% _________________________________
%  
%      FIXA INTIAL VÄRDE
%       (gissa x värde)
% _________________________________

function v=guess(x);     

y(1)=sin(2*pi*x);  %intial värde för y(1)
y(2)=cos(2*pi*x);  %intial värde för y(2)
v=[y(1);y(2)];     % v - column vector


% _________________________________
%  
%      BOUNDARY CONDITIONS
%      (beräkna gränsvärde)
% _________________________________

function residual = bcdeviation(yleft,yright,T); %yleft och yright har en column och två rader)

ya=yleft(1)-yleft(:,1)
yb=right(1)-yright(:,1)
yaa=yleft(2)-yleft(:,2)
ybb=yright(2)-yright(:,2)
yRL=yaa-ybb %yleft(2)-yright(2)

residual=[yaa;ybb;yRL]


%------------------------------------------------


solinit=bvpinit(linspece(-1,1,20),@guess);
sol=bvp4c(@ode,@residual,@solinit);
fill(sol.x,sol.y(1,:),'r')

% 
% x = linspace(0,4);
% y = deval(sol,x);
% plot(x,y(1,:));

%x(1)=0 och x(end)=1 om x=[0,1]
%x = [0, 0.5, 1, 1,  1.5, 2]; 
% the boundary conditions apply at three points: the endpoints 0 and 2,
% and the repeated entry 1. In general, repeated entries represent boundary 
% points between regions in . In the preceding example, the repeated entry 1 
% divides the interval [0,2] into two regions: [0,1] and [1,2].



