

% OBS ! det finns tre filer för tre funktion
%       1) ode
%       2) guess
%       3) bcdeviation
% samt ett fil som fixar grafer (huvud fil). här jag har samlat de
% på en fil



% _________________________________
%  
%     FIXA DIFFERENTIAL EKVATION
% _________________________________


function dydx = ode(x,y,T)
%x är radvektor 
%y har två radvektorer y1 och y2
%k får längden av x (längden av x är antal gissningar)
        
        k = length(x);

% Fixa vektor y1 med en colun och k rader---transpornat ger en rad vektor
% med k coluner.
        
        y1 = y(1:k);

% Fixa vektor vars colun börjar på 1+k och antal rader 2*k---transponat
% ger 2'k coluner och 1+k rader.
        
        y2 = y(2,:); 

% Diff.ekvivation yy1 och yy2 
        
        yy1 = 3*T*(y1 + y2 - (y1.^3)/3 - 1.3);
        yy2 = -(T/3)*(y1 - 0.7 + 0.8*y2);

%Fixa en matris av dxdy som returnerar värderna av diff.ekvationer     
        
        dydx = [yy1 yy2];
        
        
% _________________________________
%  
%      FIXA INTIAL VÄRDE
%       (gissa x värde)
% _________________________________
        

function v = guess(x)
    
%k får längden av x(längden av x är antal gissningar och det är radvektor)
   
        k = length (x);
%Då x=0 (Första rad i vektor v med):
 
        y1=sin(2*pi*0);
        y2=cos(2*pi*0);
        v =[y1; y2];
    
%fixa resten av matris med börjarn på rad 2 och slutar på rad k dvs på
% längden k som har fott av längden x
   for (i=2 : 1 : k)        
        y1 = sin(2*pi*x(i));
        y2 = cos(2*pi*x(i));
        v = [v [y1 ;y2]];
   end
  
 %matris v returneras som gisningar av x   
   
   
% _________________________________
%  
%      BOUNDARY CONDITIONS
%      (beräkna gränsvärde)
% _________________________________

    
function residual = bcdeviation(yleft,yright,T)

%yleft är en kolun vektor med två rader ---första rad yleft(1) och
%yleft=[yleft(1);yleft(2)]
%yright=[yright(1);yright(2)]
    
    resYleft1 = yleft(1);
    resYright2 = yright(1);
    resYleftYright3 = yleft(2)-yright(2);
    residual = [resYleft1; resYright2 ;resYleftYright3];
    
%det är onädigt att komentera resten utom att matris "residual" är
%en matris med en rad vektor med tre elementer
    

%----------------------------------------------   
%----------------------------------------------    
%----------------------------------------------
%----------------------------------------------
    

option = bvpset('R.T.', 1e-5, 'S.', 'po');
solinit = bvpinit(linspace(0,1,90)',@guess, 2*pi);
sol = bvp4c(@ode, @bcdeviation, solinit,option);

T = sol.parameters
tid = T*sol.x;
yy = sol.y;
tid2 = [tid T+tid];
y2 = [yy yy];
y21 = y2(1,:);
y22 = y2(2,:);

yyx = guess(linspace(0,1,150));
yy1 = yyx(1,:);
yy2 = yyx(2,:);
x = T*linspace(0,1,150); % x kordinate

% _________________________________
%  
%           PLOTTA GRAFER
%      
% _________________________________

plot(tid2,y21,'+');
plot(x,yy1);
hold
figure
plot(t2,y22,'r');
hold
plot(x,yy2);
figure
plot(y(1,:),y(2,:));

%%---------------------------------------------  
%----------------------------------------------    
%----------------------------------------------
%----------------------------------------------