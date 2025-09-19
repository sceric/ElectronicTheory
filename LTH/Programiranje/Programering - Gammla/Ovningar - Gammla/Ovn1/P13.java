import se.lth.cs.pt.io.*;

public class P13{

public static void main(String[] args){

ConsoleReader r = new ConsoleReader();
ConsoleWriter w = new ConsoleWriter();

int avgT,avgM,ankT,ankM,skortime,skorminuter, skortid1, ankT1, avgT1, skortid;


  w.print("Avgång Time:");
  avgT=r.readInt();
  
  w.print("och Minute:");
  avgM=r.readInt();
  
 
 
  w.print("Ankomst Time");
  ankT=r.readInt();
  
  w.print("och Minute");
  ankM=r.readInt();
  
    ankT1=60*ankT+ankM;
    avgT1=60*avgT+avgM;

      if(ankT1>avgT1){
         skortid1=(24-ankT)*60-(60-ankM)-(24-avgT)*60-(60-avgM);      
         skortime=skortid1/60;
         skorminuter=skortid1%60;
         w.println("SkorTid"+skortime +skorminuter); 

      }else{
         
         skortid=(24-avgT)*60+(60-avgM)+60*ankT+ankM;
         skortime=skortid/60;
         skorminuter=skortid%60;
        w.println("SkorTid"+skortime +skorminuter);
      }
  }
}