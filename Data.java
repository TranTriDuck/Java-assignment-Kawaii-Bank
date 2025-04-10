
public class Data {
    private String accountnumber;
    private String address;
    private String type;
    private double balance;

    public Data (String accountnumber, String address, String type, double balance)
    {
        this.accountnumber = accountnumber;
        this.address = address;
        this.type = type;
        this.balance = balance;
    }

  


    public String getaccountnumber() {
        return accountnumber;
    }

    public String getaddress() {
        return address;
    }

    public String gettype() {
        return type;
    }

    public double getbalance() {
        return balance;
    }
   
    public void setbalance(double newbalance)
    {
        this.balance = newbalance;
    }

}