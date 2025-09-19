function dydx = ode(x,y,T)
dydx =[3*T*(y(1) + y(2) - (y(1)^3)/3 - 1.3);-T/3*(y(1) - 0.7 + 0.8*y(2))]; 