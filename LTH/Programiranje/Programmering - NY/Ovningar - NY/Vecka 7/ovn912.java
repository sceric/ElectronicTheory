import se.lth.cs.pt.io.*;


public class ovn912{
	
	public static void main(String[]arg){
		
   String line=Keyboard.nextLine("Skriv in rad: "); //matta in en mening
   int []count=new int['z'-'a'+1];          //vektor för registrering
   int blanks=0;
   
	   for(int i=0;i<=line.length();i++){
	   	
		   	char ch=Character.toLowerCase(line.charAt(i));//returnera ch som liten bokstever
		   									//Character.toUpperCase()--returnera ch som stort bokstever
		   	if(ch>='a' && ch<='z'){         //Character.isUpperCase()--testa om det är stort bokstever
		   									//Character.isLowerCase()--testa om det är liten bokstever
		   		count[ch-'a']++;
		   		
		   		
		   	}else if(ch==' '){
		   		
		   	 blanks++;
		   	}
	   	
      }
   
    															//max storlek:
      for(int i=0;i<count.length;i++){                          //for vektor -- count.length
      															//för string -- line.length()
      	System.out.print((char)('a'+i)+" : "+count[i]+" | ");
      	
      }
        
        System.out.println(" ");
        System.out.println(" ");  
        System.out.println(" ");         	
       	System.out.println("Antal blanka tecken är " +blanks);
       	System.out.println(" ");
       }
       
       
 } 
 
 
// OBS! OBS!
// 
// java.lang.StringIndexOutOfBoundsException: String index out of range: 5
//    	at java.lang.String.charAt(String.java:455)
//    	at Nonsense.main(Nonsense.java:9)
//         Exception in thread "main" 
//      
// Du har anropat operationen str.charAt(i) med ett för stort värde på i.
// Index i strängen line räknas från 0 till line.length()-1.

