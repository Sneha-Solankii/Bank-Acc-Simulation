package bank.acc.simu;

import java.util.ArrayList;
import java.util.Scanner;

// Account class
class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount + " | New Balance: " + balance);
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be greater than 0!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount + " | New Balance: " + balance);
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // Show balance
    public void showBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Show transaction history
    public void showTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }
    // show account Details
    public void showAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
    }

}

// Main class
public class Bank_Acc_Simulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create account
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        Account acc = new Account(accNum, name, balance);

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Show Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    acc.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wit = sc.nextDouble();
                    acc.withdraw(wit);
                    break;

                case 3:
                    acc.showBalance();
                    break;

                case 4:
                    acc.showTransactionHistory();
                    break;
                    
                case 5:
                	acc.showAccountDetails();
                	break;

                case 6:
                    System.out.println("Thank you for using Bank App!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
