import java.util.ArrayList;

public class Orders {
    private  ArrayList<Order> orders;

    public  ArrayList<Order> getOrders() {
        return orders;
    }

    public ArrayList<Order> Orders_add(Order order) {
        orders.add(order);
        return orders;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order=" + orders +
                '}';
    }
}

