
/**

 * Accounts will include the following information:
    Customer name
    Account number
    Customer address
    Account type
    Current balance

    Duc Tran Tri
    
    24/3/2025
 */
public class Account
{
   //Attributes of Account class
   private String name;
   private int number;
   private String address;
   private String type;
   private String balance;
   public Account (String name, int number, String address, String type, String balance)
   {
    //Constructor of Account class
    //Set up the attributes of Account class
        this.name = name;
        this.number = number;
        this.address = address;
        this.type = type;
        this.balance = balance;
   }
   
public String getName()//Return name 
{
    return name;
   
}

public int getNumber()//Return number
{
    return number;
}

public String getAddress()//Return address
{
    return address;
   }

public String getType()//Return type
{
    return type;
}

public String getBalance()//Return balance
{
    return balance;
}

}



