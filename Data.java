
public class Data {
    private String username;
    private String accountnumber;
    private String address;
    private String type;
    private double balance;

    public Data (String username, String accountnumber, String address, String type, double balance)
    {
        this.username = username;
        this.accountnumber = accountnumber;
        this.address = address;
        this.type = type;
        this.balance = balance;
    }

    //Getter for 
    public String getUsername()
    {
        return username;
    }

    public String getAccountNumber()
    {
        return accountnumber;
    }

    public String getAddress()
    {
        return address;
    }

    public String getType()
    {
        return type;
    }

    public double getBalance()
    {
        return balance;
    }

    //


    @Override 
    public String toString()
    {
        return "Data{" +
                "username='" + username + '\'' +
                ", number=" + accountnumber +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", balance='" + balance +
                '}';
    }
} 