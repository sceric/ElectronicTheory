function dydx = ode(x,y,T)
   
        y1 = y(1,:);
        y2 = y(2,:);
        y1prim = 3*T*(y1 + y2 - (y1.^3)/3 - 1.3);
        y2prim = (-T/3)*(y1 - 0.7 + 0.8*y2);
        dydx = [y1prim y2prim];