import se.lth.cs.pt.random.*;
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.window.*;
import se.lth.cs.pt.turtle.*;


public class ovn98{
	
	public static void main(String[]arg){
		
	
		String hiddenLine=Keyboard.nextLine("Ange lösning:").toUpperCase();
		char[] pattern = new char[hiddenLine.length()];
		int nbrOfHiddenLetters=0;
		
		for(int i=0; i<hiddenLine.length();i++){
			
			if(Character.isLetter(hiddenLine.charAt(i))){
				
			 pattern[i]='-';
			 nbrOfHiddenLetters++;	
				
			}else{
				
				pattern[i]=hiddenLine.charAt(i);
				
			}
	  	}
			
			
		int nbrOfGuesses=0;
		
		while(nbrOfHiddenLetters>0){
			
			for(int i=0; i<hiddenLine.length();i++){
				
				System.out.print(pattern[i]);
			}
			
			 System.out.println();
			 char guess=Character.toUpperCase(Keyboard.nextChar("Gissa en bosktev: "));
			 Keyboard.flushLine();
			 nbrOfGuesses++;
			 
			 for(int i=0;i<hiddenLine.length();i++){
			 	
			 	if(hiddenLine.charAt(i)==guess){
			 		
			 		pattern[i]=guess;
			 		nbrOfHiddenLetters--;
			 		
			 		}			 
			
		     }
			
			
		}
         
         
        System.out.println("Du behövde "+nbrOfGuesses+" gissningar.");



	}
}