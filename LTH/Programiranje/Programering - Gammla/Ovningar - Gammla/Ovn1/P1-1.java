import se.lth.cs.pt.io.*;

public class P1 {

   public static void main (String[] args){

   SimpleWindow w = new SimpleWindow (500,500);
   Turtle t = new Turtle(w, 250,250);

   t.penDown();
   for(int i=1;i<=4;i++){
       t.forward(100);
       t.left(90);
   }
  }
}

	