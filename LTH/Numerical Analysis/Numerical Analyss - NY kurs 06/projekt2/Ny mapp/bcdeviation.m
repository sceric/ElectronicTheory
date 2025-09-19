function residual = bcdeviation(yleft,yright,T)
residual = [yleft(1);yright(1);yleft(2)-yright(2)];