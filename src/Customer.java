import java.io.Serializable;

public class Customer implements Serializable {
    private static int count;
    private String name;
    private String City;
    private int CustomerID;
    public static final long serialVersionUID = -2363428822087675831L;

    public Customer(String name, String City) {
        CustomerID=count++;
        this.name = name;
        this.City = City;
    }
    public Customer(){}

    public int getCustomerID() {
        return CustomerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public static void setCount(int count) {
        Customer.count = count;
    }

}




