
import se.lth.cs.pt.io.*;



public class ovn287{
	
	
	public static void main (String[] args){
		
     int sum=0;
     double medel=0;
     int n=Keyboard.nextInt("Ange antal tal: ");
     
     
     System.out.println(" ");
     System.out.println("Ange tal:");
     System.out.println(" ");
  
//medelvärde beräkning

	for(int i=1;i<=n;i++){

	int nub=Keyboard.nextInt();
    	sum=sum+nub;	
		
    }
    
    medel=(double)sum/n;
    
    System.out.println(" ");
    System.out.println("Medelverde är "+medel);
    System.out.println(" ");	




 } 

}