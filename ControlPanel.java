import java.util.ArrayList;
import java.util.Scanner; // Importing Scanner class for user input
//Manage teller's accounts in account manager array list
public class ControlPanel {
    private ArrayList<Account> accounts; // Array list collection of accounts
    
    private Scanner scanner; // Scanner object for user input
        public void createaccount() {
            scanner = new Scanner(System.in); // Initialize the scanner object
            //Prompt the user to create a new account
            //When user type in "A", create a new account
            System.out.print("Enter your account name: ");
             String accountname = scanner.nextLine();

            //Then get the number of the account
            System.out.print("Enter your account number in this format 00-0000-0000000-00 (e.g: 80-0101-0423087-00): ");

            String accountnumber = scanner.nextLine();


            //Getting account adress
            System.out.print("Enter your address: ");

            String address = scanner.nextLine();


            //Getting account type
            System.out.print("Enter your account type (e.g: Savings, Everyday, Current): ");
            String type = scanner.nextLine();
            
            //Create a new data object with the information provided by the user
            Account newacc = new Account(accountname, accountnumber, address, type, 0.0); // Initial balance of the account is 0.0
            // Add the new account just created to the account manager
            addaccount(newacc); // Add the new account to the array list of accounts
            //Send a message that let the user know that the account has been created
            System.out.println("Account created successfully!");
        }
    //Method to add a new account to the account manager
    public void addaccount(Account account) {
        accounts.add(account);  // Add the account to the array list
    }
    
    //Creating constructor for ControlPanel class
    public ControlPanel() {
        accounts = new ArrayList<>(); // Initialize the array list of accounts
    }



    public Account findaccountthroughnumber(String accountnumber) {
        for (Account account : accounts) { // Loop through the array list of accounts
            if (account.getaccountnumber().equals(accountnumber)) { // Check if the account number matches
                return account; // Return the matching account
            }
            else {
                System.out.println("Account not found"); // Print message if account is not found
            }
        }
        return null; // If there are no accounts matched with the account number, return null
    }

    //Method to get the list of accounts
    public ArrayList<Account> getaccounts() {
        return accounts; // Return the array list of accounts
    }

    //Method to delete an account which is "B" option
    public void deleteaccount(String accountnumber) {
        Account account = findaccountthroughnumber(accountnumber); // Find the account using the account number
        if (account != null) { // Check if the account exists
            accounts.remove(account); // Remove the account from the array list
            System.out.println("Account deleted successfully"); // Print success message
        } else {
            System.out.println("Account not found, please try again"); // Print message if account is not found
        }
    }

    public void displayaccount() {
        for (Account account : accounts) { // Loop through the array list of accounts
            System.out.println(account); // Print each account
        }
    }
    //Method to get the size of the account manager array list

    public int getsize() {
        return accounts.size(); // Return the size of the array list of accounts
    }

    //Depositing money into the account method
    //Method to deposit money into the account which is "C" option
    public void deposit(String accountnumber, double depositamount) {
        Account account = findaccountthroughnumber(accountnumber); // Finding the account using the account number
        if (account != null) { // Checking if the account exists
            account.deposit(depositamount); // Depositing the amount into the account
            System.out.println("Deposit successful"); // Sending success message for the users
        } else {
            System.out.println("Account not found, please try again"); // Printing message if account is not found
        }
    }
    public void withdraw(String accountnumber, double withdrawamount) {
        Account account = findaccountthroughnumber(accountnumber); // Find the account using the account number
        if (account != null) { // Check if the account exists
            if (withdrawamount <= account.getbalance()) { // Check if the withdrawal amount is less than or equal to the balance
                account.updatebalance(-withdrawamount); // Withdraw the amount from the account
                System.out.println("Withdrawal successful"); // Print success message
            } 
            //In case of insufficient funds, print message
            else {
                System.out.println("Insufficient funds"); // Print message if there are insufficient funds
            }
        }
        else {
            System.out.println("Account not found, please try again"); // Print message if account is not found
        }
    }

}