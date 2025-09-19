
import se.lth.cs.pt.io.*;



public class ovn24{
	
	
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
    
    int arrH= depH+travelH;
    int arrM= depM+travelM;


    if(arrM>=60){
    	 arrM=arrM-60;
    	 arrH=arrH+1;
    	
    }


    while(arrH>=24){
    
    arrH=arrH-24;	
    	
    }

   if(arrM<10){
   	
   System.out.println("Ankomstid: " +arrH +":0"+arrM);
   System.out.println(" ");

  }else{
   
   System.out.println("Ankomstid: " +arrH +":"+arrM);
   System.out.println(" ");
  	
  }
 
}
 


}