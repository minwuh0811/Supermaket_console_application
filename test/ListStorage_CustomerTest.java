import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListStorage_CustomerTest {
    String path = System.getProperty("user.home") //C:\Users\wumin_000\Desktop\testare\Utveckling av applikationer och tjänster\exerciese\projektuppgift\test\resources
            + java.io.File.separator + "Desktop"
            + java.io.File.separator + "testare"
            + java.io.File.separator + "Utveckling av applikationer och tjänster"
            + java.io.File.separator + "exerciese"
            + java.io.File.separator + "projektuppgift"
            + java.io.File.separator + "test"
            + java.io.File.separator + "resources";

    @Test
    void addCustomer() {
        ListStorage_Customer storage_customer = new ListStorage_Customer("Customer_test",path);
        int start=storage_customer.customers.size();
        storage_customer.addCustomer(new Customer());
        assertEquals(start+1,storage_customer.customers.size());
    }

    @Test
    void findCustomer() {
        ListStorage_Customer storage_customer = new ListStorage_Customer("Customer_test",path);
        Customer customer_find=storage_customer.findCustomer(0);
        String name=customer_find.getName();
        assertEquals("Min Wu",name);
    }


}