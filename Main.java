

/**
 * Main class
 *
 * @author Duc Tran Tri
 * @version 24/3/2025
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

public class Main
{
    public static void main (String [] args){

        AccountManager accountManager = new AccountManager(); // Create an AccountManager object

        //Set up scanner allow for teller put in
        Scanner scanner = new Scanner(System.in);
        
        // Create an array of possible suits (H. Dumpty, Peter Piper, Simon Sez)
        String[] names = {"H. Dumpty", "Peter Piper", "Simon Sez"};
        
        String[] addresses = {"14 Mt View St Wellington", "48B Mitchel Way Wellington", "118 The Shoreline Wellington"};
        
        String[] types = {"Savings", "Everyday", "Current"}; 
        
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
    }
    
    // Get the user' choice, ensuring it is a valid string
    String choice = scanner.nextLine();
    
    switch (choice){
        case "A":
            //When user type in "A", create a new account
            System.out.print("Enter your account name: ");
            String name = scanner.nextLine();
            name = name.trim();

            //Then get the number of the account
            System.out.print("Enter your account number: ");
            //Get the number of the account
            int number = scanner.nextInt();
            scanner.nextLine();
            
        case "B": 
            //When user type in "B", Deposit money into an account
            
            
        case "C":
            //When user type in "C", Withdraw money from an account

        case "D":
            //When user type in "D", Transfer money between accounts

        case "E":
            //When user type in "E", Display account details

        case "F":
            //When user type in "F", Exit the program
            running = false;
            break;
        
        //In case the teller type in an unexpected variables, characters, or numbers. Print out an error message and ask the teller to try again.
        default:
            System.out.println("Invalid choice. Please try again.");
            //End the program.
            break;
    }

    //Print the inforamtion of the account
    System.out.println("Name: " + name);
    System.out.println("Number: " + number);
    System.out.println("Address: " + address);
    System.out.println("Type: " + type);
    System.out.println("Balance: " + balance);

    //Close the scanner
    scanner.close();
    }
}
