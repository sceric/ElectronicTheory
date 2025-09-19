import se.lth.cs.pt.random.*;
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.window.*;
import se.lth.cs.pt.clock.Clock;
import se.lth.cs.pt.ovn.walk.*;

public class ovn810{
	
	public static void main(String[]arg){
		
		RandomNumberGenerator rng = new RandomNumberGenerator();
        StoneWindow sw = new StoneWindow();
        Clock clock = new Clock();
        
        int pfram=Keyboard.nextInt("Skriv procent för att Fred ska gå fram: ");
        int pback=Keyboard.nextInt("Skriv procent för att Fred ska gå back: ");
        int psum=pfram+pback;
        int last=1;
        int step=0;

        int allaSteg=0;
        int framSteg=0;
        int backSteg=0;

        boolean finish=false;
        boolean finish1=false;
        sw.setUp();
        sw.drawMan(last);
        



        while(!finish){
        	
        	
        clock.pause(1000);	
        sw.eraseMan(last);	
        	
        int pt=rng.randInt(1,100);
 
           if(pt<=pfram || last==0){  //framåt
        	           
            last++;
            framSteg++;

          }else if(pt>=psum){        //ramlla i vatten
        	       
        	last++;
        	framSteg++;
        	sw.drawManInWater(last);
        	    System.out.println(" ");
                System.out.println("OPS!!! Fred drunknade!!!");
        	finish=true;  //sw.eraseMan(last);den metod funka ej for sw.drawManInWater(last)
        	finish1=true;
               	       	
          }else{                      //backåt
        	
        	last--;
        	backSteg++;          	
          }	
         
       if(!finish1){
        sw.drawMan(last);
       }  
       
       if(last==10){
      	finish=true;   //avbryter program då Fred gick till mål!
       }     
        							          
     allaSteg++;
    }

    System.out.println(" "); 
    System.out.println("Antal alla steg: "+ allaSteg);
    System.out.println(" ");
    System.out.println("Antal back steg: " +backSteg);
    System.out.println(" ");
    System.out.println("Antal fram steg: " +framSteg);
    System.out.println(" ");
       
   }
}


//Problem:om man bra skriver sw.drawMan(last); efter att finish=true kommer att 
//denna operation körs och efteråt loopen while avslutas...vi vill att operation
//ska inte köras om finish=true....vi fixa en if sats med vilkor.