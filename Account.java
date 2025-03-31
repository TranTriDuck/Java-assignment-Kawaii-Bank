
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
import java.util.ArrayList;
// import java.time.LocalDate;

public class Account
{
   //Attributes of Account class
   //Constructor to create a new account with a name

   private String accountname; //The name of the account which hold the data 
   private ArrayList<Data> data;

   
   public Account (String accountname) {
        this.accountname = accountname;
        this.data = new ArrayList<>();

   }

   //Getter for account name
    public String getAccountName() {
          return accountname;
    }

    //Getter for the data in the account
    public ArrayList<Data> getData() {
        return data;
    }

    public String getFormattedAccountNumber() {
        String accountString = String.format("%08d", Integer.parseInt(accountname));
        return accountString.substring(0, 2) + "-" +
               accountString.substring(2, 6) + "-" +
               accountString.substring(6, 13) + "-00";

    }

    //Method to add a new data to the account
    public void addData(String username, String accountnumber, String address, String type, int balance) {
        data.add(new Data(username, accountnumber, address, type, balance));
    }



    //Method to list all the data in the account
    public void listData(){
        if (data.isEmpty()) {
            System.out.println("No data found in the account. please check again if you have put in data into the account or not");
        } else {
            System.out.println("Data in the account:");
            for (int i = 0; i < data.size(); i++) {
                Data d = data.get(i);
                System.out.println("Data of account:" + accountname);
                System.out.println("Username: " + d.getUsername());
                System.out.println("Number: " + d.getAccountNumber());
                System.out.println("Address: " + d.getAddress());
                System.out.println("Type: " + d.getType());
                System.out.println("Balance: " + d.getBalance());
            }
        }
    }

}
   
    //Constructor of Account class
    //Set up the attributes of Account class
   