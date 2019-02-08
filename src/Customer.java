public class Customer {
//    private static int count;
    private String name;
    private String City;
    private String CustomerID;

    public Customer(String CustomerID){
        if (CustomerID==null) {
            this.CustomerID=java.util.UUID.randomUUID().toString();
        } else {this.CustomerID=CustomerID;}

    }

    public Customer(String name, String City) {
            this(null);
            this.name=name;
            this.City=City;
    }

    public Customer(String name, String City,String CustomerID) {
        this.CustomerID = CustomerID;
        this.name = name;
        this.City = City;

    }
    public String getCustomerID() {
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

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerID='" + CustomerID + '\'' +
                ", name='" + name + '\'' +
                ", City='" + City + '\'' +
                '}';
    }

}




