import se.lth.cs.pt.io.*;
import se.lth.cs.pt.util.*;

class RegisterData  {
    private String nameOfWriter;
    private String titel;
 
    public RegisterData() { 
    ;
    }
    
    public void putWriter(String nameOfWriter) {
       this.nameOfWriter = nameOfWriter;   
    }
  
    public void putTitel(String titel) {
       this.titel = titel;
    }
   
    public String getWriter() {
       return nameOfWriter;
    }
    
    public String getTitel() {
       return titel;
    }
   
}    
class Register {
   private ConsoleWriter write;
   private ConsoleReader reader;
   private RegisterData [] rd; 
   private int antPost;
   
   public Register(String filename) {
      write = new ConsoleWriter();
      reader = new ConsoleReader();
      rd = new RegisterData[200];
      for(int k = 0;k<200;k++) 
	  rd[k] = new RegisterData();
      readFromFile(filename);
      if(rd[0].getWriter()==null) {
        rd[0].putWriter("ZZZZZZZ");
        rd[0].putTitel("ZZZZZZ"); 
        antPost = 0;
      }
   } 

   public void saveToFile(String filename) {
      FileWriter fileWriter = new FileWriter(filename);
      fileWriter.println(antPost);
      for(int i = 0; i < antPost;i++) {
        fileWriter.println(rd[i].getWriter());
        fileWriter.println(rd[i].getTitel());
      }
    }
   
    public void readFromFile(String filename) {
	if(PathFinder.fileExists(filename)) {
          FileReader fileReader = new FileReader(filename);
          antPost = fileReader.readInt();
          fileReader.flushLine();
          for(int i = 0; i < antPost; i++) {
            rd[i].putWriter(fileReader.readLine());
            rd[i].putTitel(fileReader.readLine());
          }
        }
    }
   
    public void setIn(String writer, String titel) {
      int pos = antPost-1;
      for(;pos>=0 && writer.toLowerCase().compareTo(rd[pos].getWriter().toLowerCase()) < 0; pos--){
	  rd[pos+1].putWriter(rd[pos].getWriter());
          rd[pos+1].putTitel(rd[pos].getTitel()); 
      }
      rd[pos+1].putWriter(writer);
      rd[pos+1].putTitel(titel);
      antPost++;
    }
   
    // sökning efter författare 
    public RegisterData binarySearch(String writer) {
      
      int first = 0;
      int last = antPost-1;
      while(first<=last) {
        int middle = (first + last)/2;
	if(rd[middle].getWriter().toLowerCase().indexOf(writer.toLowerCase())>=0)
	return rd[middle];
         if(writer.toLowerCase().compareTo(rd[middle].getWriter().toLowerCase()) < 0 )
          last = middle-1;
        else if(writer.toLowerCase().compareTo(rd[middle].getWriter().toLowerCase()) > 0)
          first = middle+1;
        else 
          return rd[middle];
      }
      return null;
    }
   
    //sökning efter en viss titel
    public RegisterData linearSearch(String titel) {
      int pos = 0;
      for(;pos < antPost; pos++) {
        if(titel.toLowerCase().compareTo(rd[pos].getTitel().toLowerCase()) == 0 || rd[pos].getTitel().toLowerCase().indexOf(titel.toLowerCase())>=0)
           return rd[pos];
      }
      return null;
    }
   
    // skriv ut i namnordning map författare
    public void writeWriters() {
	for(int i = 0; i < antPost; i++) {
          write.println("Författare : " + rd[i].getWriter());
          write.println("       Titel:  " + rd[i].getTitel());
        }
    }
   
    //skriv ut i namnordning map titlarna
    public void writeTitles() {
      boolean [] help = new boolean [antPost];
      int index = 0;
      for(int i = 0; i < antPost; i++) {
        String min = "ZZZZZZZZZ";
        for(int k =0; k < antPost; k++) {
	    if((rd[k].getTitel().toLowerCase().compareTo(min.toLowerCase()) < 0) && (!help[k])) {
              index = k;
              min = rd[k].getTitel();
            }
        }
        help[index] = true;
        write.println("Titel:  " + rd[index].getTitel());
        write.println("     Författare :  " + rd[index].getWriter());
      }
    }
}
       
 
   
    //huvudprogrammet
    public class Knjige {
	public static void main(String [] args) {
	  ConsoleWriter writer = new ConsoleWriter();
          ConsoleReader reader = new ConsoleReader();
          Register reg = new Register("New Fil");
          writer.println("Läser data från filen ... ");
          while(true) {
             writer.println("1.Skriv in ny författare med titel ");
             writer.println("2.Sök titeln av en vis författare");
             writer.println("3.Ta reda på vem som skrivit en viss bok ");
             writer.println("4.Skriv ut författare i namnordning");
             writer.println("5.Skriv ut titlarna i namnordning");
             writer.println("6.Spara det ändrade programmet");
             writer.println("0.Avsluta programmet");
             int nbr = reader.readInt();
             reader.flushLine();
             switch(nbr) {
	         case 0 :
                         System.exit(0);
                         break;
	         case 1 :
                         writer.println("Ange författare:");
		         String writerName = reader.readLine();
                         writer.println("Ange titeln:"); 
                         String titel = reader.readLine();
                         reg.setIn(writerName,titel);
                          break;
                 case 2 :
                         writer.println("Ange författaren du söker titeln till:");
                         String ff = reader.readLine();
                         if(reg.binarySearch(ff)!=null){
			     writer.println("Titeln är");
                            writer.println(reg.binarySearch(ff).getTitel());
                         }
                         else
                            writer.println("Författaren finns inte i listan ");
                         break;      
	         
                 case 3 :
                         writer.println("Ange titeln du söker:"); 
                         String tn =  reader.readLine();
                         if(reg.linearSearch(tn)!=null) {
                             writer.println("Författare är");
                             writer.println(reg.linearSearch(tn).getWriter());
                         }
                         else 
                             writer.println("Titeln finns ej i listan");
                         break;
         
		

	         case 4 :
                         reg.writeWriters();
                         break;
	         case 5 :
                         reg.writeTitles();
                         break;
	         case 6 :
                         reg.saveToFile("New Fil");
                         break;
	     }
          }
	}
    }
