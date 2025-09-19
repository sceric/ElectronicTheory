


function dydx = odet(x,y,T)
        k = length(x)
        y1 = y(1:k)
        y2 = y((1+k):(2*k)) 
        yy1 = 3*T*(y1 + y2 - (y1.^3)/3 - 1.3);
        yy2 = -(T/3)*(y1 - 0.7 + 0.8*y2); 
        dydx = [yy1 yy2];