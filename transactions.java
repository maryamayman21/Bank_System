import java.time.LocalDate;
import java.util.Random;
import java.util.Date;

public class Transactions {
 private long transactionID;
 private BankAccount account ;
 private LocalDate currentDate; 
 private String transactionType;

    public Transactions() {
    }
  
    public Transactions( BankAccount account) {
        this.account = account;
        this.transactionType =""; 
        this.transactionID = 0; 
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }
    
    private LocalDate getDate() {
        currentDate = LocalDate.now();
        return currentDate;
    }
 

   private long getTransactionID() {
        
        // Create an instance of the Random class
        Random random = new Random();
        
        // Generate a random transaction ID
         this.transactionID = random.nextLong();
        
        // Ensure transactionID is positive (transaction IDs should be non-negative)
        if (transactionID < 0) {
            transactionID *= -1;
        }
        
        return transactionID;
    }



    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
  
    public void Deposit(double moneyAmount){
     
        //adding on balance 
       account.setBalance(account.getBalance()+moneyAmount);
        System.out.println("Money amount is added to "+account.getAccountNumber());
        System.out.println("Your current balance is : "+account.getBalance());
                //print date and transaction id 
                        printTransactionInfo();
        
    }
    
    
    public void Withdrawal(double moneyAmount){
        
           if ( account.getBalance() >= moneyAmount){
             account.setBalance( account.getBalance() - moneyAmount);
            System.out.println(moneyAmount+"have been withdraw");
            System.out.println("Your current balance is : "+account.getBalance());
            //print date and transaction ID 
                   printTransactionInfo();
                    
        }
        else
             System.out.println("Your current balance is not qualified for this transaction");
       
    }
    
    public void Transfere(BankAccount otherAccount , double moneyAmount ){
        
        if (this.account.getBalance() < moneyAmount){
        System.out.println("Your current balance is not qualified for this transaction");
            
       }
        else {
              this.account.setBalance(account.getBalance() - moneyAmount);
             otherAccount.setBalance(otherAccount.getBalance()+moneyAmount);
             System.out.println(moneyAmount+"have been transferred to "+otherAccount.getAccountNumber());
            System.out.println("Your current balance is : "+this.account.getBalance());
            // need to print date and transaction ID
            printTransactionInfo();
           
            
        } 
        
    }
    
    
    public void checkBalance(){
        
        System.out.println("Current Balance : "+account.getBalance());
                   printTransactionInfo();
          
    }
     private void printTransactionInfo(){ 
         
       System.out.println("Transaction Type : "+getTransactionType());
       System.out.println("Transaction Date : "+getDate());
       System.out.println("Transaction ID: " + getTransactionID());
         
         
     }
    
}

