
import se.lth.cs.pt.io.*;



public class ovn516{
	
	
	public static void main (String[] args){
    
    int depH = Keyboard.nextInt("Ange avgångstime: ");
    
    while(depH>24 || depH<0){    //kontrolera att man ange korekt
    
        depH = Keyboard.nextInt("Fel,ange igen avgångstime: ");	
    	
    }

    int depM = Keyboard.nextInt("Ange avgångsminut: ");  
    
    while(depM>60 || depM<0){    //kontrolera att man ange korekt
    	
    	depM = Keyboard.nextInt("Fel,ange igen agångsminut: "); 
    	
    	
    }

    
    int travelH = Keyboard.nextInt("Ange körtid i timmar ");



    int travelM = Keyboard.nextInt("Ange körtid i minuter: ");

    while(travelM>60 || travelM<0){       //kontrolera att man ange korekt 
    	
    	travelM = Keyboard.nextInt("Fel,ange igen körtid i minuter: "); 
    	
    	
    }

    System.out.println(" ");
    System.out.println(" ");
    
    int adventH= (depH+travelH)+(depM +travelM)/60;

    int adventM= (depM+travelM)%60;
    
    if(adventH>=24){
    	
    	adventH=adventH-24;
    
    } 

   if(adventM<10){
   	
   System.out.println("Ankomstid: " +adventH +":0"+adventM);
   System.out.println(" ");

  }else{
   
   System.out.println("Ankomstid: " +adventH +":"+adventM);
   System.out.println(" ");
  	
  }
 
}
 


}