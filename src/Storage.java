import java.util.ArrayList;

public interface Storage {

    public void addCustomer(Customer customer);
    public Customer findCustomer(int customerID);
    public void PrintCustomer();
    public void addProduct(Product product);
    public void PrintProduct();
    public Product findProduct(int input);
    public void addOrder(Order order);
    public void addOrderSearch(Order order);
    public void findOrder(int customerID);
    public void close();



}
