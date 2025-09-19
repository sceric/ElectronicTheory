import se.lth.cs.pt.ovn.bank.*;


public class BankTrans {
    public static void main(String[] args) {
	Bank myBank = new Bank();
	BankTerminal myTerminal = new BankTerminal();
	TerminalController controller = new TerminalController(myBank, myTerminal);
	controller.mainLoop(); 
	
    }
}

class Account {
    private int accountNo;	// kontonummer
    private int balance;	// saldo    
    public Account(int accNo) {
	this.accountNo = accNo; 
	this.balance = 0;
    }
      /** tag reda på kontonumret */
    public int getAccountNo() {
        return this.accountNo;
    }
     /** tag reda på saldot */
    public int getBalance() {
	return  this.balance;    
    }
     /** sätt in amount kronor på kontot */
    public void deposit(int amount) {
        this.balance = this.balance + amount;
    }
      /** tag ut amount kronor från kontot */
    public void withdraw(int amount) {
	if (amount <= this.balance) {
	    this.balance = this.balance - amount;
	}
	else {
	    System.out.println("För stort belopp, du kan inte ta ut mer än "+balance+" kr!");
	}
    }
}

class Bank {
    private int n= 9;
    private Account[] accounts;
    public Bank() {
	accounts = new Account[n+1];
	for (int pos = 0 ; pos <= n;  pos++) {
	    accounts[pos] = new Account((pos*100)+100);
	}
    }
     /** tag reda på kontot med numret accNo
        ger null om kontot inte existerar */
    private Account find(int accNo) {	
	for (int i = 0; i <= n; i++) {
	     if (accounts[i].getAccountNo() == accNo) {
		return accounts[i];
	    }	
	}
	return null;
    }    
    /** tag reda på om kontot med numret accNo existerar */
    public boolean exists(int accNo) {	
        for (int i = 0; i <= n; i++) {
	    if (accounts[i].getAccountNo() == accNo) {
		return true;
	    }	
	}
	return false;
    }
     /** tag reda på saldot på kontot med numret accNo
        kontot förutsätts existera */
    public int getBalance(int accNo) {
	for (int i = 0; i <= n; i++) {
	    if (accounts[i].getAccountNo() == accNo) {
		return accounts[i].getBalance();
	    }	
	}
	return 0;
    }
    
    /** sätt in amount kronor på kontot med numret accNo
        kontot förutsätts existera */
    public void deposit(int amount, int accNo) {
	for (int k = 0; k<=n; k++) {
	    if (accounts[k].getAccountNo()==accNo) {
		accounts[k].deposit(amount);
	    }
	}
    }
      /** tag ut amount kronor från kontot med numret accNo
        kontot förutsätts existera och ha ett saldo >= amount */
    public void withdraw(int amount, int accNo) {
        for (int k = 0; k<=n; k++) {
	    if (accounts[k].getAccountNo()==accNo) {
		accounts[k].withdraw(amount);
	    }
	}
    }
}

class TerminalController {
    private Bank bank;
    private BankTerminal terminal;
    
    public TerminalController( Bank bank, BankTerminal terminal) {
	this.bank = bank;
	this.terminal = terminal;
    }
    
    public void mainLoop() {
	while (true) {
	    terminal.displayText("Specify desired function");
	    int fcn = terminal.getFunction();
	    terminal.displayText("Enter account number");
	    int accNo = terminal.getNumber();
	    if (bank.exists(accNo)) { 
		switch (fcn) {
		case 1: {terminal.displayText("Enter amount: ");   
		int amount = terminal.getNumber();
		terminal.waitForDone();
		bank.deposit(amount, accNo);
		break;
		}
		case 2: {terminal.displayText("Enter amount: ");
		int amount = terminal.getNumber();
		terminal.waitForDone();
		bank.withdraw(amount,accNo);
		break;
		}
		case 3: { int cash = bank.getBalance(accNo);
		terminal.displayNumber(cash);
		terminal.waitForDone();
		break;
		}
		}
	    }
	}
    }
}





















