function v = guess(x)
    N = length (x);
    v = [sin(2*pi*0); cos(2*pi*0)];
    for (i=2 : 1 : N)
        
        y1 = sin(2*pi*x(i));
        y2 = cos(2*pi*x(i));
        v  = [v [y1; y2]];
    end
   