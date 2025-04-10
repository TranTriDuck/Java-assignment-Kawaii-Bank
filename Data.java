
public class Data {
    // Fields to store account number, address, account type, and balance
    private String accountNumber;
    private String address;
    private String accountType;
    private double balance;

    // Constructor to initialize the Data object with account number, address, account type, and balance
    public Data(String accountNumber, String address, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.address = address;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Getters and Setters
    // Getters for each field
    public String getAccountNumber() {
        return accountNumber; // Unique identifier for the account which is number account
    }

    public String getAddress() {
        return address; // Address of the account holder
    }

    public String getAccountType() {
        return accountType; // Type of account (e.g., savings, checking)
    }

    public double getBalance() {
        return balance; // Current balance of the account
    }

    public void deposit(double amount) {
        balance += amount; // Method to deposit money into the account
    }
    
    // Returns the account number, address, account type, and balance as a string
    @Override
    public String toString() {
        return "Account number: " + accountNumber + "\n" +
               "Address: " + address + "\n" +
               "Account type: " + accountType + "\n" +
               "Balance: " + balance + "\n";
    }
}