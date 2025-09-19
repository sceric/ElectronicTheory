import se.lth.cs.pt.io.*;

public class P21{

  public static void main(String[] args){

   ConsoleReader r = new ConsoleReader();
   ConsoleWriter w = new ConsoleWriter();

   int lenght;
   double Nvikt, NviktU;
   char tecken;

   w.print("Trick knapen -(man=M, kvinna=K)");
   
   tecken=r.readChar();

       if(tecken=='M'){

         w.println("Ange längd:");
         lenght=r.readInt();
         Nvikt=lenght-108;
         NviktU=0.95+Nvikt;

         if(Nvikt<NviktU){

            w.println("Du är undernärd!");

         }else if(Nvikt>NviktU){
               
                 w.println("Du är välnärd!");
          
         }else{

                 w.println("Ej definierat!");

         }
       
   
 
      }else if(tecken=='K'){
  
            w.println("Ange längd:");
            lenght=r.readInt();
            Nvikt=lenght-112;
            NviktU=1.05+Nvikt;

            if(Nvikt<NviktU){

              w.println("Du är undernärd!");

            }else if(Nvikt>NviktU){
               
                    w.println("Du är välnärd!");
          
            }else{

                 w.println("Ej definierat!");

            }
 

       }else{ 
         
            w.println("Ej definierat!");

       }


  }
}
     

