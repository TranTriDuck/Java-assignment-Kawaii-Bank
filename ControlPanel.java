//Importing necessary packages
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner; 

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

    
    //Method to find an account using the account number
    public Account findaccountthroughnumber(String accountnumber) {
        // Loop through the array list of accounts to find the account with the given account number
        for (Account account : accounts) { // Loop through the array list of accounts
            if (account.getAccountNumber().equals(accountnumber)) { // Check if the account number matches
                return account; // Return the matching account
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

    //Method to get the size of the account manager array list

    public int getsize() {
        return accounts.size(); // Return the size of the array list of accounts
    }

    //Depositing money into the account method
    //Method to deposit money into the account which is "C" option
    public void deposit(String accountNumber, double depositAmount) {
        Account account = findaccountthroughnumber(accountNumber); // Finding the account using the account number
        if (account != null) { // Checking if the account exists
            account.deposit(depositAmount); // Depositing the amount into the account
            System.out.println("Deposit successful"); // Sending success message for the users
        } else {
            System.out.println("Account not found, please try again"); // Printing message if account is not found
        }
    }

    //Method to withdraw money from the account which is "D" option
    public void withdraw(String accountNumber, double amount) {
        // Find the account using the account number
        Account account = findAccountThroughNumber(accountNumber);
        // Check if the account exists
        if (account != null) {
            // Check if the withdrawal amount exceeds the limit which is $5000
            // The limit is set to $5000 for all account types
            if (amount > 5000) {
                // Print error message if the withdrawal amount exceeds the limit
                System.out.println("❌ Withdrawal amount exceeds the $5000 limit.");
                return;
            }
            // Check the account type and apply withdrawal rules
            // For Everyday and Savings accounts, check if the user's balance is sufficient
            if (account.getAccountType().equalsIgnoreCase("Everyday") || account.getAccountType().equalsIgnoreCase("Savings")) {
                if (account.getBalance() >= amount) {
                    account.updateBalance(-amount);
                    System.out.println("✅ Withdrawal successful!");
                } else {
                    System.out.println("❌ Insufficient funds. Everyday and Savings accounts cannot go into debt.");
                }
            // For Current accounts, check if the user's balance is sufficient with overdraft limit
            } else if (account.getAccountType().equalsIgnoreCase("Current")) {
                // Check if the withdrawal amount exceeds the overdraft limit of $1000
                if (account.getBalance() - amount >= -1000) {
                    // Update the balance with the withdrawal amount
                    account.updateBalance(-amount);
                    System.out.println("✅ Withdrawal successful!");
                } else {
                    // Print error message if the withdrawal amount exceeds the overdraft limit
                    System.out.println("❌ Insufficient funds. Current accounts have a $1000 overdraft limit.");
                }
            } else {
                System.out.println("❌ Unknown account type.");
            }
        } else {
            System.out.println("❌ Account not found.");
        }
    }
    
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = findAccountThroughNumber(fromAccountNumber);
        Account toAccount = findAccountThroughNumber(toAccountNumber);
    
        // Check if both accounts exist
        if (fromAccount != null && toAccount != null) {
            // Check if the transfer amount exceeds the limit which is $5000
            if (amount > 5000) {
                System.out.println("❌ Transfer amount exceeds the $5000 limit.");
                return;
            }
    
            if (fromAccount.getAccountType().equalsIgnoreCase("Everyday") || fromAccount.getAccountType().equalsIgnoreCase("Savings")) {
                // Check if the user's balance is sufficient for Everyday and Savings accounts
                if (fromAccount.getBalance() >= amount) {
                    fromAccount.updateBalance(-amount);
                    toAccount.updateBalance(amount);
                    System.out.println("✅ Transfer successful!");
                } else {
                    System.out.println("❌ Insufficient funds. Everyday and Savings accounts cannot go into debt.");
                }
            } else if (fromAccount.getAccountType().equalsIgnoreCase("Current")) {
                if (fromAccount.getBalance() - amount >= -1000) {
                    fromAccount.updateBalance(-amount);
                    toAccount.updateBalance(amount);
                    System.out.println("✅ Transfer successful!");
                } else {
                    System.out.println("❌ Insufficient funds. Current accounts have a $1000 overdraft limit.");
                }
            } else {
                System.out.println("❌ Unknown account type.");
            }
        } else {
            System.out.println("❌ One or both accounts not found.");
        }
    }

    //Method to display account details which is "D" option
    public void displayaccountdetails(String accountNumber) {
        // Find the account using the account number
        Account account = findAccountThroughNumber(accountNumber);
        if (account != null) {
            System.out.println(account.toString());
        } else {
            System.out.println("Account not found, please try again.");
        }
    }


    //Method to save account details 
    public void saveaccountdetails(String accountnumber) {
        Account account = findaccountthroughnumber(accountnumber); // Find the account using the account number
        if (account != null) { // Check if the account exists
            // Save the account details to a file or database (not implemented in this code)
            System.out.println("Account details saved successfully"); // Print success message
        } else {
            System.out.println("Account not found, please try again"); // Print message if account is not found
        }
    }

    // //  Method to save account data into a CSV file
    //  public void saveAccountDataToCSV(String filePath) {
    //     try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
    //         // Write the header row
    //         writer.write("Account Name,Account Number,Address,Account Type,Balance\n");

    //         // Write account details
    //         for (Account account : accounts) {
    //             // Write each account's details in CSV format
    //             writer.write(account.getAccountName() + "," +
    //                          account.getAccountNumber() + "," +
    //                          account.getAddress() + "," +
    //                          account.getAccountType() + "," +
    //                          account.getBalance() + "\n");
    //         }

    //         System.out.println("Account data saved to " + filePath);
    //     } catch (IOException e) {
    //         // Print error message if file cannot be created or written to
    //         System.out.println("ERROR: Could not save account data to CSV file.");
    //         e.printStackTrace();
    //     }
    // }
    public void saveToCSV(String filePath) {
        try {
            System.out.println("Saving to file: " + filePath); // Debugging log
            java.io.File file = new java.io.File(filePath);
            java.io.File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                System.out.println("Creating directories: " + parentDir.getAbsolutePath());
                parentDir.mkdirs(); // Create directories if they don't exist
            }
    
            try (java.io.FileWriter writer = new java.io.FileWriter(file, true)) {
                for (Account account : accounts) {
                    writer.append(account.getAccountName()).append(",")
                          .append(account.getAccountNumber()).append(",")
                          .append(account.getAddress()).append(",")
                          .append(account.getAccountType()).append(",")
                          .append(String.valueOf(account.getBalance())).append("\n");
                }
                System.out.println("Data saved successfully.");
            }
        } catch (java.io.IOException e) {
            System.out.println("An error occurred while saving to CSV: " + e.getMessage());
        }
    }

    //Method to delete an account which is "B" option
 public void deleteAccount(String accountNumber) {
        accounts.removeIf(account -> account.getAccountNumber().equals(accountNumber));
    }

    //Method to find an account using the account number
    public Account findAccountThroughNumber(String accountNumber) {
        for (Account account : accounts) {
            // Check if the account number matches the given account number
            if (account.getAccountNumber().equals(accountNumber)) {
                // Return the account if found
                return account;
            }
          
        }
        return null; // If no account is found, return null
    }

    // Save account data to a file
    public void saveData(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Number of accounts: " + accounts.size() + "\n");
            writer.write("Account data:\n");
            for (Account account : accounts) {
                writer.write(account.getAccountName() + "," +
                             account.getAccountName() + "," +
                             account.getAccountNumber() + "," +
                             account.getAddress() + "," +
                             account.getAccountType() + "," +
                             account.getBalance() + "\n");
            }
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("ERROR: Could not save data to file.");
        }
    }

    // Load account data from a file
    public void loadData(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            accounts.clear(); // Clear existing accounts
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Account data:")) {
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        // Check if the line has the correct number of parts
                        // Adjust the number of parts based on your data format
                        if (parts.length == 5) {
                            String accountName = parts[0];
                            String accountNumber = parts[1];
                            String address = parts[2];
                            String accountType = parts[3];
                            double balance = Double.parseDouble(parts[4]);
                            // Create a new Account object and add it to the accounts list
                            accounts.add(new Account(accountName, accountNumber, address, accountType, balance));
                        }
                    }
                }
            }
            // Print the number of accounts loaded
            System.out.println("Data loaded successfully!");
        } catch (IOException e) {
            // Print error message if file not found or cannot be read
            System.out.println("ERROR: Could not load data from file.");
        }
    }
}
            
        
    

 