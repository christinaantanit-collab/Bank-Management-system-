import java.util.ArrayList;
import java.util.Scanner;

public class BankManagement {
    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Bank Management System ===");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Delete Account");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: viewAccounts(); break;
                case 3: depositMoney(); break;
                case 4: withdrawMoney(); break;
                case 5: checkBalance(); break;
                case 6: deleteAccount(); break;
                case 7: System.out.println("Thank you!"); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 7);
    }

    static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        System.out.print("Enter Account Holder Name: ");
        String name = sc.next();
        System.out.print("Enter Account Type (Savings/Current): ");
        String type = sc.next();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        accounts.add(new BankAccount(accNo, name, type, balance));
        System.out.println("Account Created Successfully!");
    }

    static void viewAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found!");
        } else {
            for (BankAccount a : accounts) {
                a.display();
            }
        }
    }

    static void depositMoney() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        boolean found = false;
        for (BankAccount a : accounts) {
            if (a.accountNumber == accNo) {
                System.out.print("Enter Deposit Amount: ");
                double amount = sc.nextDouble();
                a.balance += amount;
                System.out.println("Deposited! New Balance: Rs." + a.balance);
                found = true;
            }
        }
        if (!found) System.out.println("Account not found!");
    }

    static void withdrawMoney() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        boolean found = false;
        for (BankAccount a : accounts) {
            if (a.accountNumber == accNo) {
                System.out.print("Enter Withdrawal Amount: ");
                double amount = sc.nextDouble();
                if (amount > a.balance) {
                    System.out.println("Insufficient Balance!");
                } else {
                    a.balance -= amount;
                    System.out.println("Withdrawn! Remaining: Rs." + a.balance);
                }
                found = true;
            }
        }
        if (!found) System.out.println("Account not found!");
    }

    static void checkBalance() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        for (BankAccount a : accounts) {
            if (a.accountNumber == accNo) {
                System.out.println("Balance: Rs." + a.balance);
            }
        }
    }

    static void deleteAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        accounts.removeIf(a -> a.accountNumber == accNo);
        System.out.println("Account Deleted!");
    }
}
