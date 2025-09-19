
import se.lth.cs.pt.io.*;


public class Tecken {
	
	public static void main(String[]arg){
		
		
        String str = Keyboard.next("Ange ett ord: "); //skappa objekt som kan ej ändras
        String spr = Keyboard.next("Ange anan ord: ");
        int sum = 0;
        int sum1 = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                sum += ch - 'a' + 1;
            }
        }

        System.out.println("Bokstavssumman är " + sum);
        
        for (int i = 0; i < spr.length(); i++) {
            char ch = spr.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                sum1 += ch - 'a' + 1;
            }
        }

        System.out.println("Bokstavssumman är " + sum1);        
        
        
        
        
        
        
        
    }


}