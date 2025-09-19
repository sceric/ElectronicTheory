
import se.lth.cs.pt.io.*;

public class Polygoner{

   public static void main(String[] args){

    
    ConsoleWriter w = new ConsoleWriter();

     int [] count = new int[11];  // har 11 element---först index är 0 och sist 10
     int  area,  area1=0, index;

     for(int i=1 ; i<=1000; i++){

          Polygon p= new Polygon();

          count[p.getNbrOfSides()]=i+1;
         

          area=p.getArea();     // här kan man undvika att skriva den sats men i if sats

           if(area>area1){          //man skriver if(p.getArea()> area1)

               area=area1;
               index=i;

           }

  
               w.println(NbrOfSides +":" +count[NbrOfSides]);
               w.println( "Störst area har Polygon nbr" +index +"och area är"+area1);


        }
} }