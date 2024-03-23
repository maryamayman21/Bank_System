package com.mycompany.quizplatform;
import java.util.Random;


public class BankAccount {
 private long accountNumber;
 private double balance;
 private int customerID;
 protected String bankType;
 
 public BankAccount(){
     
        
 }
            
    public BankAccount(long accountNumber ,  double balance, int customerID) {
       this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerID = customerID;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

   

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

     private long getRandomAccountNumber() {
        
        // Create an instance of the Random class
        Random random = new Random();
        
        // Generate a random transaction ID
         this.accountNumber= random.nextLong();
        
        // Ensure transactionID is positive (transaction IDs should be non-negative)
        if (accountNumber < 0) {
            accountNumber *= -1;
        }
        
        return accountNumber;
    }

   public void printAccountInfo(){
       System.out.println(" Account Number :" +accountNumber);
       System.out.println("Customer ID :" +getCustomerID());
       System.out.println("Balance : "+ getBalance());
           
   }
    

}


class SavingAccount extends BankAccount{
    
private double interest; 

    

    public SavingAccount(double interest,long accountNumber ,double balance, int customerID) {
        super(accountNumber  , balance, customerID);
        this.interest = interest;
        bankType = "Saving Account";
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void printAccountInfo(){
       super.printAccountInfo();
        System.out.println("Interest : "+getInterest());
        System.out.println( "Bank account type" +bankType);
       
   }
       
}

class CreditAccounts extends BankAccount{
    
  private double limit; 

    public CreditAccounts() {
    }

    public CreditAccounts(long accountNumber  , double balance, int customerID ,  double limit) {
       super(accountNumber  , balance, customerID);
        this.limit = limit;
        this.bankType = "Credit Account";
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public void printAccountInfo(){
       super.printAccountInfo();
        System.out.println("Limit Amount : "+getLimit());
        System.out.println( "Bank account type" +bankType);
       
       
   }
  
}
