import java.util.ArrayList;

public class Customers {
    
 private long ID; 
 private String name ;
 private String address;
 private String  contactInfo;
 private  ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>(); 

    public Customers() {
    }

    public Customers(long ID, String name, String address, String contactInfo) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
        
    }

    

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
    
    public void setBankAccounts(ArrayList<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

   public void getCustomerInfo(){
       
       System.out.println("Name :" +getName());
       System.out.println("Address :" +getAddress());
       System.out.println("ID :" +getID());
       System.out.println("Contact Information :" +getContactInfo());
       //print Account details
       for(BankAccount bank :bankAccounts ){
              bank.printAccountInfo();
               
       }
       
       
   }
    
    
}
