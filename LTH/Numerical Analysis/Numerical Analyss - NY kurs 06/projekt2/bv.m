


solinit=bvpinit(linspece(-1,1,20),@guess);
sol=bvp4c(@ode,@residual,@solinit);
fill(sol.x,sol.y(1,:),'r')