
import se.lth.cs.pt.io.*;



public class ovn288{
	
	
	public static void main (String[] args){
		
     int sum=0;
     int countn=0;
     int countp=0;

     System.out.println(" ");
     System.out.println("Antal tal: ");
     int nub=Keyboard.nextInt();
  
//medelvärde beräkning

	while(nub!=0){

     if(nub<0){
     	
     	countn++;
     
     	
     }else{
     	
     	countp++;
     	    	
     }
	
    nub=Keyboard.nextInt();		
		
    }
    
   
    
    System.out.println(" ");
    System.out.println("Antal pozitiva tal er "+countp);
    System.out.println(" ");
    System.out.println("Antal negativa tal er "+countn);
    System.out.println(" ");	




 } 

}