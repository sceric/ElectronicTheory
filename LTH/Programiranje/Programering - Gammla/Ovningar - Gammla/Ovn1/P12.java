import se.lth.cs.pt.io.*;
import se.lth.cs.pt.turtle.*;
import se.lth.cs.pt.window.*;

public class P12{

public static void main (String[] args){

SimpleWindow w = new SimpleWindow (600,600);
Turtle t = new Turtle(w,250,250);

 t.right(90);
 t.penDown();

     for(int i=1;i<=3;i++){
         t.forward(100);
         t.left(120);
     }

  t.jumpTo(300,300);
      for(int i=1;i<=3;i++){
        t.forward(100);
        t.left(120);
    }
  }
}

