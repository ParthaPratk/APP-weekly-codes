import java.util.Scanner;

class BankAccount {
    
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn successfully.");
        }
    }

    // Display account details
    public void displayDetails() {
        System.out.println("\n----- Account Details -----");
        System.out.println("Account Number     : " + accountNumber);
        System.out.println("Account Holder     : " + accountHolderName);
        System.out.println("Current Balance    : " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accountNumber = sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();

       
        BankAccount account = new BankAccount(accountNumber,accountHolderName,initialBalance);

     
        System.out.print("\nEnter amount to deposit: ");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);

  
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = sc.nextDouble();
        account.withdraw(withdrawAmount);

    
        account.displayDetails();

        sc.close();
    }
}