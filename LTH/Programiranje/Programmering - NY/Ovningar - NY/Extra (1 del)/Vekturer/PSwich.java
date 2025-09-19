import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;


public class PSwich{
	
	public static void main(String[]arg){
		
		
       RandomNumberGenerator rng = new RandomNumberGenerator();
	   
      System.out.println("1.Utskrift är SEFIK");
      System.out.println("2.Utskrift är EMINA");
      System.out.println("3.Utskrift är MELISA");
      System.out.println("4.Utskrift är MIRSO");
      System.out.println("5.Utskrift är EDIN");
      System.out.println("6.Utskrift är ADELINA");
      

       int n;
       do{
	   n=Keyboard.nextInt("Skriv NUMER vilken du vill att skrivas ut: ");
       }while(n>=6 || n<=1);
	   

       switch(n){
       
       case 1:
           		System.out.println("1.Utskrift är SEFIK");
           		break; 
       case 2:
       			System.out.println("1.Utskrift är EMINA");
       			break; 
       case 3:
       			System.out.println("1.Utskrift är MELISA");
       			break; 
       case 4:
       			System.out.println("1.Utskrift är MIRSO");
       			break; 
       case 5:
       			System.out.println("1.Utskrift är EDIN");
       			break; 
       case 6:
       			System.out.println("1.Utskrift är ADELINA");
       			break; 
       
       
       //default: (vid behöv)
       
      }
  
   


	   
  }
 }