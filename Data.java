
public class Data {
    private String name;
    private int number;
    private String address;
    private String type;
    private String balance;
    private boolean isCompleted; // Update the completion status of the data

    public Data (String name, int number, String address, String type, String balance)
    {
        this.name = name;
        this.number = number;
        this.address = address;
        this.type = type;
        this.balance = balance;
    }

    public String getName()
    {
        return name;
    }

    public int getNumber()
    {
        return number;
    }

    public String getAddress()
    {
        return address;
    }

    public String getType()
    {
        return type;
    }

    public String getBalance()
    {
        return balance;
    }

    public void markIncomplete()
    {
        isCompleted = false;
    }   

@Override
    public String toString()
    {
        return "Data{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", balance='" + balance + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
} 