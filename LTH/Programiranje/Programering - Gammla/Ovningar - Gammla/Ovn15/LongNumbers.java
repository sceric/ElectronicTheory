import se.lth.cs.pt.ovn.longnumber.*;     
// klasserna BasicLNumber och LNumberView
class LNumber extends BasicLNumber {
    /** skapa ett L-tal med plats för wholeDig siffror i
        heltalsdelen och plats för decDig decimaler */
    public LNumber(int wholeDig,int decDig) {
        super(wholeDig,decDig);
    }

    /** Tilldelning:  L-nbr = int-nbr */
    public void assign(int nbr) {
	 
	int pos = 0;
	for( int i=-decDig;i<=wholeDig-1;i++)
	    putDigit(0,i);
        do {
            putDigit(nbr%10,pos);
            nbr /= 10;
            pos++;
        } while (nbr != 0);
    }

    /** Addition:  L-nbr = L-nbr + L-nbr1 */
    public void add(LNumber lnbr1) {
	int carry = 0;
	for (int pos=-decDig; pos<=wholeDig-1; pos++) {
	    int dig = getDigit(pos)+lnbr1.getDigit(pos)+carry;
	    putDigit(dig%10,pos);
	    carry = dig/10;
	}
    }

    /** Subtraktion:  L-nbr = L-nbr - L-nbr1 */
    public void sub(LNumber lnbr1) {
	int borrow = 0;
	for (int pos=-decDig; pos<=wholeDig-1; pos++) {
	    int dig = getDigit(pos)-borrow-lnbr1.getDigit(pos);
	    if (dig<0) {
		dig += 10;
		borrow = 1;
	    }else{
		borrow=0;
	    }
	    putDigit(dig,pos);
	}
    }
     
    /** Multiplikation:  L-nbr = L-nbr * int-nbr */
    public void mul(int nbr) {
        int carry = 0;
        for (int pos=-decDig; pos<=wholeDig-1; pos++) {
            int prod = getDigit(pos)*nbr+carry;
            putDigit(prod%10,pos);
            carry = prod/10;
        }
    }
    
    /** Division:  L-nbr = L-nbr / int-nbr */
    public void div(int nbr) {
	int carry = 0;
        for (int pos=wholeDig-1; pos>=-decDig; pos--) {
	    int num = carry*10+getDigit(pos);
            putDigit(num/nbr,pos);
            carry = num%nbr;
	   
        }
    }

    /** Jämförelse:  L-nbr == L-nbr1 */
    public boolean equal(LNumber lnbr1) {
        int pos = -decDig;
        while (pos<=wholeDig-1 && getDigit(pos)==lnbr1.getDigit(pos))
            pos++;
        return pos>wholeDig-1;
    }
}


/** klass för beräkning av exp(x) och sin(x),    
    metoderna är, liksom i standardklassen Math, statiska */ 	      
class PTMath {
    
    /** beräkna exp(x) där x är int-tal, resultatet är L-tal med 
        wholeDig heltalssiffror och decDig decimaler */
    public static LNumber exp(int x, int wholeDig, int decDig) {
        LNumber zero = new LNumber(wholeDig,decDig);
        zero.assign(0);
        LNumber sum = new LNumber(wholeDig,decDig);
        sum.assign(1);
        LNumber term = new LNumber(wholeDig,decDig);
        term.assign(x);
        int k = 1;
        while (!term.equal( zero)) {
            sum.add(term);
            k++;
            term.assign(1);
            for (int i=1; i<=k; i++){
                term.mul(x);
                term.div(i);
	    }
	    //   System.out.println("exp");
        }
        return sum;
    }
    
    /** beräkna sin(x) där x är int-tal, resultatet är L-tal med     
        wholeDig heltalssiffror och decDig decimaler */
    public static LNumber sin(int x, int wholeDig, int decDig) {
	LNumber zero = new LNumber(wholeDig,decDig);
	zero.assign(0);
        LNumber sum = new LNumber(wholeDig,decDig);
        sum.assign(0);
        LNumber term = new LNumber(wholeDig,decDig);
        term.assign(x);
	
        int k = 1;
        boolean plus = true;
        while (!term.equal(zero)) {
            if (plus)
                sum.add(term);
            else
                sum.sub(term);
            k += 2;
            plus = !plus;
  	    term.assign(1);
  	    for (int i=1; i<=k; i++){
		term.mul(x);       
		term.div(i);
	    }
	}
	return sum;
    }	
    
       
}


// huvudprogram
public class LongNumbers {
    
    public static void main(String[] args) {
	LNumber exp1 = new LNumber(5,100);
	exp1 = PTMath.exp(1,5,100);
	LNumberView exp1View = new LNumberView("exp(1)");
	exp1View.display(exp1);
	LNumber exp2 = new LNumber(5,100);
	exp2 = PTMath.exp(2,5,100);
	LNumberView exp2View = new LNumberView("exp(2)");
	exp2View.display(exp2);
	LNumber sin1 = new LNumber(5,100);
	sin1 = PTMath.sin(1,5,100);
	LNumberView sin1View = new LNumberView("sin(1)");
	sin1View.display(sin1);
	LNumber sin2 = new LNumber(5,100);
	sin2 = PTMath.sin(2,5,100);
	LNumberView sin2View = new LNumberView("sin(2)");
	sin2View.display(sin2);
	/**
	   LNumber test = new LNumber(5,10);
	   LNumber test2 = new LNumber(5,10); 
	   LNumberView testView = new LNumberView("test");
	*/
	//testView.display(test);
	//testView.waitForMouseClick();
	//test.assign(3);
	//testView.display(test);
	//test.equal();
	//	testView.display(test);
	/**
	   test.assign(11);
	   test2.assign(7);
	   test.sub(test2);
	   testView.display(test);
	*/
    }
}



