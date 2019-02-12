import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListStorage_OrderTest {
    String path = System.getProperty("user.home") //C:\Users\wumin_000\Desktop\testare\Utveckling av applikationer och tjänster\exerciese\projektuppgift\test\resources
            + java.io.File.separator + "Desktop"
            + java.io.File.separator + "testare"
            + java.io.File.separator + "Utveckling av applikationer och tjänster"
            + java.io.File.separator + "exerciese"
            + java.io.File.separator + "projektuppgift"
            + java.io.File.separator + "test"
            + java.io.File.separator + "resources";

    @Test
    void addOrder() {
        ListStorage_Order storage_order = new ListStorage_Order("Order",path);
        int start=storage_order.orders.size();
        Customer customer=new Customer("NoName","Nocity");
        ProductHem producthem=new ProductHem(new Drink("NoName",0.0),0.0);
        Order order=new Order(customer,producthem);
        storage_order.addOrder(order);
        assertEquals(start+1,storage_order.orders.size());
    }

    @Test
    void addOrderSearch() {
        ListStorage_Order storage_orderresearches = new ListStorage_Order("Order",path);
        int start=storage_orderresearches.ordersearches.size();
        Customer customer=new Customer("NoName","Nocity");
        ProductHem producthem=new ProductHem(new Drink("NoName",0.0),0.0);
        Order order=new Order(customer,producthem);
        storage_orderresearches.addOrderSearch(order);
        assertEquals(start+1,storage_orderresearches.ordersearches.size());
    }

    @Test
    void findOrder() {
        ListStorage_Order storage_order = new ListStorage_Order("Order_test",path);
        ArrayList<Order> orderresearch_result =storage_order.findOrder(0);
       assertEquals(5,orderresearch_result.size());
    }
}