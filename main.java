package com.mycompany.quizplatform;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizPlatform {
   
    public static int verifyAccountNumber(ArrayList<Customers> customers, long accountNumber) {
        for (Customers customer : customers) {
            ArrayList<BankAccount> customerAccount = customer.getBankAccounts();
            for (BankAccount acc : customerAccount) {
                if (acc.getAccountNumber() == accountNumber) {
                    return 1;
                }
            }    
        }
        return 0;
    }
    
    public static BankAccount getAccount(ArrayList<Customers> customers, long accountNumber) {
        for (Customers customer : customers) {
            ArrayList<BankAccount> customerAccount = customer.getBankAccounts();
            for (BankAccount acc : customerAccount) {
                if (acc.getAccountNumber() == accountNumber) {
                    return acc; 
                }
            }    
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Customers> customers = new ArrayList<>();

        Customers customer1 = new Customers(122345, "John Smith", "789 Oak Lane, Anywhere City, USA", "+967 107848603");
        SavingAccount savingAcc1 = new SavingAccount(15, 20888903, 4000, 122345);
        CreditAccounts creditAcc1 = new CreditAccounts(4456789, 2000, 122345, 15000);
        ArrayList<BankAccount> customerAcc1 = new ArrayList<BankAccount>();
        customerAcc1.add(savingAcc1);
        customerAcc1.add(creditAcc1);
        customer1.setBankAccounts(customerAcc1);
        customers.add(customer1);

        Customers customer2 = new Customers(122459, "William Jones", "101 Maple Drive, Nowhere Town, USA", "+955 127783960");
        CreditAccounts creditAcc2 = new CreditAccounts(1232345, 5500, 122459, 15000);
        ArrayList<BankAccount> customerAcc2 = new ArrayList<BankAccount>();
        customerAcc2.add(creditAcc2);
        customer2.setBankAccounts(customerAcc2);
        customers.add(customer2);

        System.out.println("Enter your account number: ");
        long accountNumber;
        while (true) {
            try {
                accountNumber = input.nextLong();
                if (verifyAccountNumber(customers, accountNumber) == 1) {
                    break;
                } else {
                    System.out.println("Invalid account number. Please try again: ");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid account number: ");
                input.next(); // Consume invalid input
            }
        }

        System.out.println("For Balance Inquiry: Enter 1");  
        System.out.println("For Cash Withdrawal: Enter 2");  
        System.out.println("For Deposit: Enter 3");  
        System.out.println("For Transfer: Enter 4"); 
        System.out.println("For Exit: Enter 0"); 
                   
        int transactionOption;
        while (true) {
            try {
                transactionOption = input.nextInt();
                if (transactionOption >= 0 && transactionOption <= 4) {
                    break;
                } else {
                    System.out.println("Invalid option. Please try again: ");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option: ");
                input.next(); // Consume invalid input
            }
        }
        
        BankAccount account = getAccount(customers, accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            System.exit(0);
        }

        Transactions customerTransaction = new Transactions(account);
        double moneyAmount = 0;
        switch(transactionOption) {
            case 0:
                System.exit(0);
                break;
            case 1:
                customerTransaction.setTransactionType("Balance Inquiry");
                customerTransaction.checkBalance();
                break;
            case 2:
                System.out.println("Enter Cash Amount: ");
                moneyAmount = input.nextDouble();
                customerTransaction.setTransactionType("Cash Withdrawal");
                customerTransaction.Withdrawal(moneyAmount);
                break;
            case 3:
                System.out.println("Enter Amount: ");
                moneyAmount = input.nextDouble();
                customerTransaction.setTransactionType("Deposit");
                customerTransaction.Deposit(moneyAmount);
                break;
            case 4:
                System.out.println("Enter recipient account number: ");
                long recipientAccNum;
                while (true) {
                    try {
                        recipientAccNum = input.nextLong();
                        if (verifyAccountNumber(customers, recipientAccNum) == 1) {
                            break;
                        } else {
                            System.out.println("Invalid recipient account number. Please try again: ");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid recipient account number: ");
                        input.next(); // Consume invalid input
                    }
                }
                System.out.println("Enter money Amount: ");
                moneyAmount = input.nextDouble();
                customerTransaction.setTransactionType("Money Transfer");
                BankAccount recipientAccount = getAccount(customers, recipientAccNum);
                if (recipientAccount != null) {
                    customerTransaction.Transfere(recipientAccount, moneyAmount);
                } else {
                    System.out.println("Recipient account not found.");
                }
                break;
            default:
                System.out.println("Invalid option.");
                System.exit(0);
                break;
        }
    }
}
