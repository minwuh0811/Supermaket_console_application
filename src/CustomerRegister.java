import java.util.ArrayList;

public class CustomerRegister {
    private Customer customer;
    private ArrayList<Customer> customers= new ArrayList<>();

    @Override
    public String toString() {
        return "CustomerRegister{" +
                "customer=" + customers +
                '}';
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList Customer_add(Customer customer) {
        customers.add(customer);
        return customers;

    }
}
