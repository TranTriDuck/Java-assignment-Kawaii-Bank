

/**
 * Main class
 *
 * @author Duc Tran Tri
 * @version 24/3/2025
 */

import java.util.Scanner;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Arrays;
// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.Collections;

public class Main
{
    public static void main (String [] args){

        // Accountmanager accountmanager = new Accountmanager();// Create an AccountManager object

        //Set up scanner allow for teller put in
        Scanner scanner = new Scanner(System.in);
        
        // Create an array of possible suits (H. Dumpty, Peter Piper, Simon Sez)

        String[] accountnumbers = {"8-0101-0423087-00", "8-0101-0423087-00", "8-0101-0423087-00"};

        String[] accountnames = {"Mr. Dumpty Dummy", "Mr. Peter Piper Pepper", "Mr. Simon Sez Swager"};

        String[] usernames = {"H. Dumpty", "Peter Piper", "Simon Sez"};
        
        String[] addresses = {"14 Mt View St Wellington", "48B Mitchel Way Wellington", "118 The Shoreline Wellington"};
        
        String[] types = {"Savings", "Everyday", "Current"}; 

        double balance = 0.0; // Initial balance for the account
        
    boolean running = true; // Main loop control variable
        
    while (running) {
        // Display the main menu
        System.out.println("\nKawaii Bank");
        System.out.println("A. Create a new account");
        System.out.println("B. Deposit money into an account");
        System.out.println("C. Withdraw money from an account");
        System.out.println("D. Transfer money between accounts");
        System.out.println("E. Display account details");
        System.out.println("F. Exit");
        System.out.println("Please enter your the number of choice for the following options: ");
    
    
    // Get the user' choice, ensuring it is a valid string
    String choice = scanner.nextLine();
    
    switch (choice){
        case "A":
            //When user type in "A", create a new account
            System.out.print("Enter your account name: ");
            String name = scanner.nextLine();
            name = name.trim();

            //Then get the number of the account
            System.out.print("Enter your account number in this format 00-0000-0000000-00 (e.g: 8-0101-0423087-00): ");

            String accountnumber = scanner.nextLine();
            accountnumber = accountnumber.trim();

            
        case "B": 
            //When user type in "B", Deposit money into an account
            //Get the amount of money to deposit
            // System.out.print("Enter the amount of money to deposit: ");
            // int deposit = scanner.nextInt();
            scanner.nextLine();

        case "C":
            //When user type in "C", Withdraw money from an account

        case "D":
            //When user type in "D", Transfer money between accounts

        case "E":
            //When user type in "E", Display account details
            //Print the inforamtion of the account
            System.out.println("Account Name: " + accountnames[0]);
            System.out.println("Account Number: " + accountnumbers[0]);
            System.out.println("Username: " + usernames[0]);
            System.out.println("Address: " + addresses[0]);
            System.out.println("Type: " + types[0]);
            System.out.println("Balance: " + balance);

        case "F":
            //When user type in "F", Exit the program
            running = false;
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
