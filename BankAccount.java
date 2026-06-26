public class BankAccount {
    int accountNumber;
    String accountHolder;
    String accountType;
    double balance;

    BankAccount(int accountNumber, String accountHolder,
                String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.balance = balance;
    }

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: Rs." + balance);
        System.out.println("----------");
    }
}
