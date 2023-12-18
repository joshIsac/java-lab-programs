/**
 * BankInterface
 */
public interface BankInterface 
 {
    void deposit(int amount);
    abstract double getBalance();
    abstract double getInterestRates();
//implementation of interface 
public class BankA implements BankInterface 
{
    private double balance;
    
    @Override
    public void deposit(int amount) 
    {
        balance=balance+amount;
    }
    @Override
    public double getBalance()
     {
        return balance*getInterestRates()+balance; //
     }
     @Override
     public double getInterestRates() {
         return 0.07;
     }
 }
 //BankB class implementing BankInterface
 public class BankB implements BankInterface {
     private double balance;
 
     @Override
     public void deposit(int amount) {
         balance = balance+amount;
     }
 
     @Override
     public double getBalance() {
         return balance*getInterestRates()+balance; ///
     }
 
     @Override
     public double getInterestRates() {
         return 0.074;
     }
 }
 
 // BankC class implementing BankInterface
 public class BankC implements BankInterface {
     private double balance;
 
     @Override
     public void deposit(int amount) {
         balance=balance+amount;
     }
 
     @Override
     public double getBalance() {
         return balance*getInterestRates()+balance; ///
     }
 
     @Override
     public double getInterestRates() {
         return 0.079;
     }
 }
 }
 
 // Main class
public class Main1 {
    public static void main(String[] args) {
         BankInterface.BankA bank1 = new BankInterface.BankA();
         BankInterface.BankB bank2 = new  BankInterface.BankB();
         BankInterface.BankC bank3 = new  BankInterface.BankC();

        bank1.deposit(10000);
        System.out.println("\nAfter Depositing 10,000:");
        System.out.println("Account Balance in Bank A: " + bank1.getBalance());
        System.out.println("Interest Rate for Bank A : " + bank1.getInterestRates());

        // Bank B
        
        bank2.deposit(150000);
        System.out.println("\nAfter Depositing 150,000:");
        System.out.println("Account Balance in Bank B : " + bank2.getBalance());
        System.out.println("Interest Rate for Bank B : " + bank2.getInterestRates());

        // Bank C

        bank3.deposit(200000);
        System.out.println("\nAfter Depositing 200,000:");
        System.out.println("Account Balance in Bank C: " + bank3.getBalance());
        System.out.println("Interest Rate for Bank C : " + bank3.getInterestRates());
    }
}
