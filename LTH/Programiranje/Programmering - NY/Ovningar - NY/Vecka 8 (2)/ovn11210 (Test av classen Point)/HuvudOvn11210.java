import se.lth.cs.pt.io.*;

public class HuvudOvn11210{

public static void main(String[] args){



 Point p1= new Point(Keyboard.nextDouble("Ange p1:s x-kordinat: "),Keyboard.nextDouble("Ange p1:s y-kordinat: "));
 Point p2= new Point(Keyboard.nextDouble("Ange p2:s x-kordinat: "),Keyboard.nextDouble("Ange p2:s y-kordinat: "));
 Point p3= new Point(Keyboard.nextDouble("Ange p3:s x-kordinat: "),Keyboard.nextDouble("Ange p3:s y-kordinat: "));


 
 System.out.println(); 
 System.out.println("Avstondet mellan mittpunkte4rna är "+p1.midpoint(p2).distanceTo(p2.midpoint(p3)));
 System.out.println();
  }
}


//p1.midpoint(p2)----mitt punkten mellan punkten p1 och p2;
//p2.midpoint(p3)----mitt punkten mellan punkten p2 och p3;
//p1.midpoint(p2).distanceTo(p2.midpoint(p3)) distancen mellan mitt punkten;