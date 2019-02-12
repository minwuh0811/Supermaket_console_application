import java.util.ArrayList;

public interface Storage_Order {
    public void addOrder(Order order);
    public ArrayList<Order> findOrder(int customerID);
    public void addOrderSearch(Order order);
}
