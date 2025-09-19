                    % makes numerical output in double precision
T = linspace(0,100,21);     % create vector theta
x = 5*cos(T);                   % generate x-coordinate
y = 5*sin(T);                  % generate y-coordinate
interpol(T,x)
interpol(T,y)

axis('equal');                    % set equal scale on axes per pixel
title('Lagrande interpolation')    % put title
