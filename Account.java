
/**

 * Accounts will include the following information:
    Customer name
    Account number
    Customer address
    Account type
    Current balance

    Duc Tran Tri
    
    //udapte data every day if possible (last version update)

    24/3/2025
 */

//import java.time.LocalDate; 
// import java.time.LocalDate;

public class Account
{
    private double balance; // The current balance of the account
   //Attributes of Account class
   //Constructor to create a new account with a name

   private String accountname; //The name of the account which hold the data 
   private String accountnumber; // The account number
    private String address; // The address of the account holder
   private String type; // The type of the account

   
   public Account (String accountname, String accountnumber, String address, String type, double balance) {
        this.accountname = accountname;
        this.accountnumber = accountnumber; 
        this.address = address;
        this.type = type;
        this.balance = balance;

   }

    //Adding getter for accountname
     public String getaccountname() {
             return accountname;
     }
   //Adding getter for balance
    public double getbalance() {
          return balance;
    }


   //Getting acountnumber
    public String getaccountnumber() {
          return accountnumber;
    }

    //Updating balance of a account method
    public void updatebalance(double amount) {
        this.balance += amount;
    }

    //Depositing money into the account method
    public void deposit(double depositamount) {
        balance += depositamount;
    }

    @Override
    public String toString() {
        return "\n🏦 Account Details 🏦\n" +
               "▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔▔\n" +
               "🔢 Account Number: " + accountnumber + "\n" +
               "🏠 Address: " + address + "\n" +
               "💼 Account Type: " + type + "\n" +
               "💰 Balance: $" + String.format("%,.2f", balance) + "\n" +
               "────────────────────────────\n";
    }
}
