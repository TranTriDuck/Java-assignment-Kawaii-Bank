import java.util.ArrayList;

//Manage teller's accounts in account manager array list
public class Accountmanager {
    private ArrayList<Account> accounts; // Array list collection of accounts
    

public Accountmanager() {
        accounts = new ArrayList<>(); // Initialize the array list of accounts
    }
    
    //Method to add a new account to the account manager
    public void addAccount(String accountname) {
        Account account = new Account(accountname); // Create a new account object
        accounts.add(account); // Add the account to the array list
    }
        
    //Method to get the list of accounts
    public ArrayList<Account> getAccounts() {
        return accounts; // Return the array list of accounts
    }

    //Transfer money between accounts


}