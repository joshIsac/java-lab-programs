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
        return balance;
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
         return balance;
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
         return balance;
     }
 
     @Override
     public double getInterestRates() {
         return 0.079;
     }
 }
 
 // Main class
 public class Main
  {
     public static void main(String[] args) {
         BankInterface bankA = new BankA();
         BankInterface bankB = new BankB();
         BankInterface bankC = new BankC();
         ((BankA) bankA).deposit(10000);
         ((BankB) bankB).deposit(150000);
         ((BankC) bankC).deposit(200000);
 
         System.out.println("Bank A balance: " + bankA.getBalance());
         System.out.println("Bank A interest rate: " + bankA.getInterestRates() * 100 + "%");
 
         System.out.println("Bank B balance: " + bankB.getBalance());
         System.out.println("Bank B interest rate: " + bankB.getInterestRates() * 100 + "%");
 
         System.out.println("Bank C balance: " + bankC.getBalance());
         System.out.println("Bank C interest rate: " + bankC.getInterestRates() * 100 + "%");
     }
 }
}