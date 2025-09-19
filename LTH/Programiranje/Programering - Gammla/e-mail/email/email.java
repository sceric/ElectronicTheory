import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;

 public class email extends Applet implements ActionListener

   {
     Button button1,button2,button3,button4,button5,                                     button1a,button2a,button3a,button4a,button5a,button6,button6a;

     Label label1,label2,label3,label4,label5,label2a,label2b,
           label2c,label2d;
 
     Font font1,font2,font3;

     Color color1;

     Image image1;

   public void init()

       {


       button1=new Button("Ny mail");
       button1a=new Button("Skicka!");
       button2=new Button("Inkorgen");
       button2a=new Button("Stäng");
       button3=new Button("Utkorgen");
       button3a=new Button("Stäng");
       button4=new Button("Sickat");
       button4a=new Button("Stäng");
       button5=new Button("Borttaget");
       button5a=new Button("Stäng");
       button6=new Button("Adressbok");
       button6a=new Button("Stäng");


       label1=new Label(" E-mail  ");
       label2=new Label   ("Program gjurt av:                     ");
       label2a=new Label("                    1.Sefik            ");
       label2b=new Label("                    2.Bengt            ");
       label2c=new Label("                    3.Mirsad           ");
       label2d=new Label("                    4.Kamal            ");

       color1=new Color(250,200,0);

       image1=getImage(getCodeBase(),"sol.jpg");

       font1=new Font("Arial",Font.BOLD,15);
       font2=new Font("Arial",Font.BOLD + Font.ITALIC,35);
       font3=new Font("Arial",Font.BOLD,10);

       button1.setFont(font1);
       button1.setFont(font1); 
       button1a.setFont(font1); 
       button2.setFont(font1); 
       button2a.setFont(font1); 
       button3.setFont(font1); 
       button3a.setFont(font1); 
       button4.setFont(font1); 
       button4a.setFont(font1);
       button5.setFont(font1); 
       button5a.setFont(font1); 
       button6.setFont(font1);  
       button6a.setFont(font1);  

 


       button1.setBackground(Color.blue);
       button2.setBackground(Color.blue);
       button3.setBackground(Color.blue);
       button4.setBackground(Color.blue);
       button5.setBackground(Color.blue);
       button6.setBackground(Color.blue);

       button1a.setBackground(Color.red);
       button2a.setBackground(Color.red);
       button3a.setBackground(Color.red);
       button4a.setBackground(Color.red);
       button5a.setBackground(Color.red);
       button6a.setBackground(Color.red);
     
      button1.setForeground(Color.cyan);
      button1a.setForeground(Color.cyan);
      button2.setForeground(Color.yellow);
      button2a.setForeground(Color.yellow);
      button3.setForeground(Color.yellow);
      button3a.setForeground(Color.yellow);
      button4.setForeground(Color.yellow);
      button4a.setForeground(Color.yellow);
      button5.setForeground(Color.yellow);
      button5a.setForeground(Color.yellow);
      button6.setForeground(Color.yellow);
      button6a.setForeground(Color.yellow);


      label1.setForeground(Color.black);
      label2.setForeground(Color.black);
      label2a.setForeground(Color.black);
      label2b.setForeground(Color.black);
      label2c.setForeground(Color.black);
      label2d.setForeground(Color.black);
 
      label1.setBackground(color1);
      label2.setBackground(Color.cyan);
      label2a.setBackground(Color.cyan);
      label2b.setBackground(Color.cyan);
      label2c.setBackground(Color.cyan);
      label2d.setBackground(Color.cyan);

      label1.setFont(font2);
      label2.setFont(font3);
      label2a.setFont(font3);
      label2b.setFont(font3);
      label2c.setFont(font3);
      label2d.setFont(font3);

      setLayout(null);
         
         button1.setBounds(10,175,130,30);
         button1a.setBounds(10,175,130,30);
         button2.setBounds(10,220,130,30);
         button2a.setBounds(10,220,130,30);
         button3.setBounds(10,265,130,30);
         button3a.setBounds(10,265,130,30);
         button4.setBounds(10,310,130,30);
         button4a.setBounds(10,310,130,30);
         button5.setBounds(10,355,130,30);
         button5a.setBounds(10,355,130,30);
         button6.setBounds(10,400,130,30);
         button6a.setBounds(10,400,130,30);

         label1.setBounds(10,20,130,60);
         label2.setBounds(10,80,130,15);
         label2a.setBounds(10,95,130,15);
         label2b.setBounds(10,110,130,15);
         label2c.setBounds(10,125,130,15);
         label2d.setBounds(10,140,130,15);

        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);

        add(label1);
        add(label2);
        add(label2a);
        add(label2b);
        add(label2c);
        add(label2d);
        
         button1.addActionListener(this);
         button2.addActionListener(this);
         button3.addActionListener(this);
         button4.addActionListener(this);
         button5.addActionListener(this);
         button6.addActionListener(this);

         button1a.addActionListener(this);
         button2a.addActionListener(this);
         button3a.addActionListener(this);
         button4a.addActionListener(this);
         button5a.addActionListener(this);
         button6a.addActionListener(this);
 
 
       }


        public void paint(Graphics g)

           {

              g.drawImage(image1,1,1,this);

           }
       
    
    public void actionPerformed(ActionEvent e)
      {

       if(e.getSource()==button1)

       { add(button1a);
         remove(button1);
       
        
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        
       remove(button2a);
       remove(button3a);
       remove(button4a);
       remove(button5a);
       remove(button6a);





        }   


     if(e.getSource()==button2)

       {
        add(button2a);
         remove(button2);
       
        
        add(button1);
        add(button3);
        add(button4);
        add(button5);
        add(button6);

       remove(button1a);
       remove(button3a);
       remove(button4a);
       remove(button5a);
       remove(button6a);
       
        } 
   
      if(e.getSource()==button3)

       {

         add(button3a);
         remove(button3);
       
         
        add(button1);
        add(button2);
        add(button4);
        add(button5);
        add(button6);

       remove(button2a);
       remove(button1a);
       remove(button4a);
       remove(button5a);
       remove(button6a);

       }     

     
     if(e.getSource()==button4)

       {

         add(button4a);
         remove(button4);
       
 
        add(button1);
        add(button2);
        add(button3);
        add(button5);
        add(button6);

       remove(button2a);
       remove(button1a);
       remove(button3a);
       remove(button5a);
       remove(button6a);

       } 

     if(e.getSource()==button5)

       {

         add(button5a);
         remove(button5);
       
        
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button6);

       remove(button2a);
       remove(button1a);
       remove(button3a);
       remove(button4a);
       remove(button6a);
        
       } 

    if(e.getSource()==button6)

       {

         add(button6a);
         remove(button6);
       
        
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);

       remove(button2a);
       remove(button1a);
       remove(button3a);
       remove(button4a);
       remove(button5a);
        
       } 



     if(e.getSource()==button1a)

       {

         add(button1);
         remove(button1a);
        
        }

   if(e.getSource()==button2a)

       {

         add(button2);
         remove(button2a);

       }

   if(e.getSource()==button3a)

       {

         add(button3);
         remove(button3a);

        }

   if(e.getSource()==button4a)

       {

         add(button4);
         remove(button4a);

       }

    if(e.getSource()==button5a)

       {

         add(button5);
         remove(button5a);

       }


    if(e.getSource()==button6a)

       {

         add(button6);
         remove(button6a);

       } 

   }

}    