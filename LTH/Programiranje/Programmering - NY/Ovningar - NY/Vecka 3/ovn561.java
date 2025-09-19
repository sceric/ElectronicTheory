
import se.lth.cs.pt.io.*;



public class ovn561{
	
	
	public static void main (String[] args){
 
 
  
  String name1=Keyboard.nextLine("Skriv in det första namnet: ");
  String name2=Keyboard.nextLine("Skriv in det andra namnet: ");
		  
		  if(name1.length()==name2.length()){
		  	
		  	System.out.println(" ");		  	
		  	System.out.println("De båda namnen är lika långa!");
		  	
		  			  	
		  }else if(name1.length()>name2.length()){
		  	
		  	System.out.println(" ");
		  	System.out.println("Namnen: " +name1 +" är längre!");
		  	
		  }else{
		  	
		  	System.out.println(" ");
		  	System.out.println("Namnen: " +name2 +" är längre!");
		  			  	
           }
		  
      	
      	if(name1.equals(name2)){
      		
      		System.out.println(" ");
      		System.out.println("De båda namnen är lika !");

      	}else if(name1.compareTo(name2)<0){
      		
      		System.out.println(" ");
      		System.out.println("Namnen "+name1 +" kommer först i bukstavsordning!");

        }else{
        	
        	System.out.println(" ");
        	System.out.println("Namnen "+name2 +" kommer först i bukstavsordning!");
        	        	
        }
 
     System.out.println(" ");
 
    }
    


}
 

// Om vi vill jämföra längden av två strengar skrivs sats 
//          if(name1.length()==name2.length()).... om de är lika
//          if(name1.length()>name2.length()).....om de är inte lika
//          
// Om vi vill veta vilken streng kommer först i bukstavsordning:
// 		  if(name1.equals(name2))....om de börja med samma bokstavsordning
// 		  if(name1.compareTo(name2)<0)...name1 före name2 i bokstavsordning
// 		  if(name1.compareTo(name2)>0)...name2 före name1 i bosktavsordning
 
