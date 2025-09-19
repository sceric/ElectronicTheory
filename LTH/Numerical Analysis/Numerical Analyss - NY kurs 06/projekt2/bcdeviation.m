function residual = bcdeviation(yleft,yright,T)
    
    residual1 = yleft(1);
    residual2 = yright(1);
    residual3 = yleft(2)-yright(2);
    residual = [residual1; residual2; residual3];