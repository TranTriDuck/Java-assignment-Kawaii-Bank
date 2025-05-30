

/**
 * Main class
 *
 * @author Duc Tran Tri
 * @version 24/3/2025
 */
// Importing necessary classes
import java.util.Scanner;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Arrays;
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
// import java.io.FileNotFoundException;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.Collections;

public class Main
{
    private static final String DEFAULT_CSV_FILE = "saveData.csv"; // Default CSV file name
    /**
     * Method to get a valid amount from the user.
     * Ensures the input is a positive number.
     *
     * @param scanner Scanner object for user input
     * @param prompt  Prompt message to display
     * @return A valid positive double amount
     */
    public static double getValidAmount(Scanner scanner, String prompt) {
        boolean valid = false;
        double amount = 0;



        while (!valid) {
            try {
                System.out.print(prompt);
                amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                if (amount > 0) {
                    valid = true;
                } else {
                    System.out.println("❌ Amount must be positive!");
                }
            } catch (Exception e) {
                System.out.println("❌ Invalid input! Numbers only please!");
                scanner.nextLine(); // Clear invalid input
            } 
        }
        return amount;
    }
    public static void main (String [] args)
    {

        // controlpanel instance for managing accounts
        ControlPanel controlPanel = new ControlPanel();
        //Creating a csv file
        // String myaccountfile = "saveData.csv"; // File name for account data
        // controlPanel.saveToCSV(myaccountfile); // Save account data to CSV file

        // Automatically load data from the default CSV file
        System.out.println("Loading account data from " + DEFAULT_CSV_FILE + "...");
        controlPanel.loadData(DEFAULT_CSV_FILE); // Load data from the CSV file

        //Set up scanner allow for teller put in
        Scanner scanner = new Scanner(System.in);
        
   

    boolean programcondition = true; // Main loop control variable
        
    while (programcondition) {
        // Display the main menu
        System.out.println("Welcome to Kawaii Bank");
        System.out.println("|-----------------------------------MENU------------------------------------|");
        System.out.println("A. Create a new account");
        System.out.println("B. Delete an account");
        System.out.println("C. Deposit money into an account");
        System.out.println("D. Withdraw money from an account");
        System.out.println("E. Transfer money between accounts");
        System.out.println("F. Display account details");
        System.out.println("G. Exit and save the data");    
        System.out.println("Please enter your character option of choice for the following options: ");
        
        // Auto uppercase the input
        // Get the user' choice, ensuring it is a valid string which means it will be invalid if the user types in a number or a special character
        String option = scanner.nextLine().toUpperCase();
    
    

    switch (option){
        case "A":
            //When user type in "A", create a new account with createaccount method
            controlPanel.createaccount();
            break;
        
        case "B":
            //When user type in "B", delete an account
            System.out.print("Enter the account number to delete: ");
            String deleteaccountnumber = scanner.nextLine();

            //Delete the account using the account manager
            controlPanel.deleteaccount(deleteaccountnumber);

            break;

        case "C": 
            //When user type in "C", Deposit money into an account
            System.out.print("Enter the account number to deposit into: ");
            String depositAccountNumber = scanner.nextLine();
             double depositAmount = getValidAmount(scanner, "Enter the amount to deposit: ");
            controlPanel.deposit(depositAccountNumber, depositAmount);
            controlPanel.logTransaction("Deposit of $" + depositAmount + " into account " + depositAccountNumber);
    break;

        case "D":
            //When user type in "D", Withdraw money from an account
           System.out.print("Enter the account number to withdraw from: ");
            String withdrawAccountNumber = scanner.nextLine();
            double withdrawAmount = getValidAmount(scanner, "Enter the amount to withdraw: ");                controlPanel.withdraw(withdrawAccountNumber, withdrawAmount);
            break;
        case "E":

            //When user type in "E", Transfer money between accounts
            System.out.print("Enter the source account number: ");
            String fromAccountNumber = scanner.nextLine();
            System.out.print("Enter the destination account number: ");
            String toAccountNumber = scanner.nextLine();
            // Validate the transfer amount
            double transferAmount = getValidAmount(scanner, "Enter the amount to transfer: ");
            controlPanel.transfer(fromAccountNumber, toAccountNumber, transferAmount);
            break;
          
        case "F":
            //When user type in "F", Display account details
            //Print the inforamtion of the account
            System.out.print("Enter the account number to display: ");
            String displayaccountnumber = scanner.nextLine();
            //Calling the displayaccountdetails method from the account manager
            controlPanel.displayaccountdetails(displayaccountnumber);



            break;
        case "G":
           
            // Save account data to CSV file
            controlPanel.saveToCSV(DEFAULT_CSV_FILE); // Save account data to CSV file
          
             // Display transactions and total balance
            System.out.println("\n📜 Transaction History:");
            for (String transaction : controlPanel.getTransactions()) {
            System.out.println(transaction);
            }
            System.out.println("\n💰 Total Balance of All Accounts: $" + String.format("%,.2f", controlPanel.calculateTotalBalance()));

            programcondition = false;
            System.out.println("Exiting the program. Thank you for using Kawaii Bank!");
            break;
        
        //In case the teller type in an unexpected variables, characters, or numbers. Print out an error message and ask the teller to try again.
        default:
            System.out.println("Invalid choice. Please try again.");
            break;
        } 

    }

    
    //Close the scanner
    scanner.close();
    }
}

