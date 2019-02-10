import java.io.Serializable;

public class Customer implements Serializable {
    private static int count;
    private String name;
    private String City;
    private int CustomerID;

    public Customer(String name, String City) {
        CustomerID=count++;
        this.name = name;
        this.City = City;
    }

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
    @Override
    public String toString() {
        return "Customer{" +
                "CustomerID='" + CustomerID + '\'' +
                ", name='" + name + '\'' +
                ", City='" + City + '\'' +
                '}';
    }
}




