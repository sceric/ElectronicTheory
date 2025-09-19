
import se.lth.cs.pt.io.*;

class SamplesF10 {

    public static void main(String[] args) {
        Account acc1 = new Account(1010);
        Account acc2 = new Account(1020);
        Account acc3 = new Account(1020);
        acc1.deposit(1000);
        acc2.deposit(1000);
        double amount = Keyboard.nextDouble("Belopp att ta ut: ");
        double withdrawn = acc2.withdraw(amount);
        System.out.println("Vi fick ut " + withdrawn + " kronor");
        System.out.println("Saldo på konto 1: " + acc1.getBalance());
        System.out.println("Saldo på konto 2: " + acc2.getBalance());
    }
}

class Account {

    private int accNo;
    private double balance;

    public Account(int accountNumber) {
        this.accNo = accountNumber;
        this.balance = 0;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double withdraw(double amount) {
        if (amount < 0) {
            return 0;
        }
        if (this.balance < amount) {
            double oldBalance = this.balance;
            this.balance = 0;
            return oldBalance;
        } else {
            this.balance -= amount;
            return amount;
        }
    }

    public double getBalance() {
        return this.balance;
    }
}
