import se.lth.cs.pt.io.*;

public class P14{

   public static void main(String[] args){

    ConsoleReader r = new ConsoleReader();
    ConsoleWriter w = new ConsoleWriter();

    int i, nextBigger=0, bigger=0, carrent, difference;

    System.out.println("Ange 10 tal!!!:");
 
      for(i=1;i<=10;i++){
      carrent= r.readInt();
      
             if(carrent>bigger){

              nextBigger=bigger; 
              bigger=carrent;

      }else{
  
       nextBigger=carrent;
      }
   
    }

    System.out.println("Next Bigger" +nextBigger);
    System.out.println("Bigger" +bigger);
    
    difference=bigger-nextBigger;
    System.out.println("Skillnaden är:"+difference);
  
  }
}