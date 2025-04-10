

/**
 * Main class
 *
 * @author Duc Tran Tri
 * @version 24/3/2025
 */
import java.io.File;
import java.util.Scanner;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Arrays;
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
// import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
// import java.util.Collections;

public class Main
{
    public static void main (String [] args)
    {

        // controlpanel instance for managing accounts
        ControlPanel controlpanel = new ControlPanel();

        //Set up scanner allow for teller put in
        Scanner scanner = new Scanner(System.in);
        
        File myAccountFile = new File("saveData.txt"); // File name for account data
        
        //Load the account data from the file
        try {
            /*write to the file*/
            FileWriter myWriter = new FileWriter(myAccountFile);

            //write the size of the array list
            myWriter.write("Number of accounts: " + controlpanel.getaccounts().size() + "\n");
            
            //write the array list of accounts
            for (int i = 0; i < controlpanel.getaccounts().size(); i++) {
                myWriter.write("Account " + (i + 1) + ": " + controlpanel.getaccounts().get(i) + "\n");
            }


            //write the account data into the file
            myWriter.write("Account data:\n");
            myWriter.write("Account number: " + controlpanel.getaccounts() + "\n");
            myWriter.write("Address: " + controlpanel.getaccounts() + "\n");
            myWriter.write("Account type: " + controlpanel.getaccounts() + "\n");
            myWriter.write("Balance: " + controlpanel.getaccounts() + "\n");
           
            /*clean up */
            myWriter.flush();
            myWriter.close();
        } catch (IOException e) {
            System.out.println("ERROR: Could not write file");
        }
    

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
            controlpanel.createaccount();
            break;
        
        case "B":
            //When user type in "B", delete an account
            System.out.print("Enter the account number to delete: ");
            String deleteaccountnumber = scanner.nextLine();

            //Delete the account using the account manager
            controlpanel.deleteaccount(deleteaccountnumber);

            break;

        case "C": 
            //When user type in "C", Deposit money into an account
            System.out.print("Enter the account number to deposit into: ");
            String depositaccountnumber = scanner.nextLine();

            System.out.print("Enter the amount to deposit: ");
            double depositamount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            //Calling the deposit method from the account manager
            controlpanel.deposit(depositaccountnumber, depositamount);
            
     
            break;

        case "D":
            //When user type in "C", Withdraw money from an account

        case "E":
            //When user type in "E", Transfer money between accounts

        case "F":
            //When user type in "F", Display account details
            //Print the inforamtion of the account
            System.out.print("Enter the account number to display: ");
            String displayaccountnumber = scanner.nextLine();
            Account displayaccount = controlpanel.findaccountthroughnumber(displayaccountnumber); // Find the account using the account number
            if (displayaccount != null) { // Check if the account exists
                System.out.println("Account details: " + displayaccount.toString());
            } else {
                System.out.println("Account not found. Please check the account number and try again.");
            }

            break;
        case "G":
            //When user type in "G", Exit the program and save the data
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

