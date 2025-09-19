import se.lth.cs.pt.io.*;
// import Person;
// import Register;


public class Huvudprogram {

    public static void main(String [] args) {

	Register reg = new Register(450);
	
          
          
	System.out.println("Läser data från Register... ");
	System.out.println();

          
          
          
	while(true) {
		System.out.println();
	    System.out.println("1.Mata in ny person ");
	    System.out.println("2.Ta bort person");
	    System.out.println("3.Sok nummer till person ");
	    System.out.println("4.Se vem som har givet nummer");
	    System.out.println("5.Skriv ut alla personer");
	    System.out.println("0.Avsluta programmet");
	    System.out.println();
	    
	    int nbr = Keyboard.nextInt("Ange kommando (0-5): ");	    
	    Keyboard.flushLine();
	    System.out.println();

	    switch(nbr) {

	    case 0 :
				System.exit(0);
				break;


	    case 1 :
				System.out.println();
				String myName = Keyboard.nextLine("Ange Person:");	
				String nummer = Keyboard.nextLine("Ange Nummer:");
				System.out.println();
	
				if (myName != null && nummer != null) {
				    
				    reg.insert(myName,nummer);
					
				 }
		               
				break;


	    case 2 :
				System.out.println();
				String myName1 = Keyboard.nextLine("Namn: ");
				System.out.println();
				if (myName1 != null) {
				    if (reg.remove(myName1)) {
					System.out.println(myName1 + " borttages.");
					System.out.println();
				    } else {
					System.out.println(myName1 + " fanns inte i listan.");
					System.out.println();
				    }
				}
				break;
			         


	    case 3 :
				System.out.println(); 
				String myName2 = Keyboard.nextLine("Ange namn: ");
				
				Person pers=reg.findByName(myName2);
                
				if (myName2 != null) {
				    
				    System.out.println(myName2 +" har numret "+pers.getNumber());
				    
				}else{
					
					System.out.println("Det finns ingen sodan person !");
					
				}
				break;
         


	    case 4 :
				System.out.println(); 
				String myNumer = Keyboard.nextLine("Ange nummer: ");
				
				Person num=reg.findByNumber(myNumer);
                
				if (myNumer != null) {
				    
				    System.out.println(myNumer +" innehas av "+num.getName());
				    
				}
				break;


	    case 5 :
			    System.out.println();
				System.out.println("Foljande peroner är registrerade:");
				System.out.println();
			     
			    Person []person=reg.finAll();
			    
			     
			     int index=0;
			     	         
                   while(index>=0 && person[index]!=null){

		         	System.out.println((index+1)+"." +person[index].getName()+" : "+person[index].getNumber());
		         	
		         	index++;		         	

				   }
				
				System.out.println();
				break;


		default:		       
		       nbr = Keyboard.nextInt("Fel! Age igen kommando(0-5): ");	    
		       Keyboard.flushLine();
		       System.out.println();
	    }
	}
	
  }
    
}



