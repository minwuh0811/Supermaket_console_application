import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AllTest {
//    String path = System.getProperty("user.home") //C:\Users\wumin_000\Desktop\testare\Utveckling av applikationer och tjänster\exerciese\projektuppgift\test\resources
//            + java.io.File.separator + "Desktop"
//            + java.io.File.separator + "testare"
//            + java.io.File.separator + "Utveckling av applikationer och tjänster"
//            + java.io.File.separator + "exerciese"
//            + java.io.File.separator + "projektuppgift"
//            + java.io.File.separator + "test"
//            + java.io.File.separator + "resources";
    String path="D:"
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
        assertEquals(9,orderresearch_result.size());
    }
    @Test
    void addProduct() {
        ListStorage_Product storage_product = new ListStorage_Product("Product_test", path);
        int start = storage_product.products.size();
        storage_product.addProduct(new Product());
        assertEquals(start + 1, storage_product.products.size());
    }

    @Test
    void findProduct() {
        ListStorage_Product storage_product = new ListStorage_Product("Product_test", path);
        Product product_find = storage_product.findProduct(0);
        String name = product_find.getProductname();
        assertEquals("Apple", name);
    }
    @Test
    void firstLettertoUpperCase() {
        String testInput = "min Wu";
        String testresult = Main.FirstLettertoUpperCase(testInput);
        assertEquals("Min Wu", testresult);
    }

    @Test
    void isFirstLetterUppcaseReturnsTrue() {
        String testInput = "Min Wu";
        boolean testresult = Main.isFirstLetterUppcase(testInput);
        assertTrue(testresult);
    }

    @Test
    void isFirstLetterUppcaseReturnsFalse() {
        String testInput = "min Wu";
        boolean testresult = Main.isFirstLetterUppcase(testInput);
        assertFalse(testresult);
    }

    @Test
    void isFirstLetterUppcaseEmptyStringReturnsFalse() {
        String testInput = "";
        boolean testresult = Main.isFirstLetterUppcase(testInput);
        assertFalse(testresult);
    }

    @Test
    void isFirstLetterUppcaseNullReturnsFalse() {
        String testInput = null;
        boolean testresult = Main.isFirstLetterUppcase(testInput);
        assertFalse(testresult);
    }

    @Test
    void getCustomerNameFirstLetterUppcase() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/LowercaseToUppcase.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            String testresult = main.getCustomerName();
            assertEquals("Min Wu", testresult);
        }
    }

    @Test
    void getCustomerName() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getCustomerName.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            String testresult = main.getCustomerName();
            assertEquals("Min Wu", testresult);
        }
    }

    @Test
    void getCustomerNameEmptyReturnsException() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getCustomerNameEmpty.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            assertThrows(NoSuchElementException.class, () -> main.getCustomerName());
        }
    }

    @Test
    void getCustomerNameIntReturnsEmpty() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getCustomerNameIntReturnsEmpty.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            assertEquals("", main.getCustomerName());
        }
    }

    @Test
    void getInt() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getInt.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            int testresult = main.getInt(11);
            assertEquals(2, testresult);
        }
    }

    @Test
    void getIntStringReturnsZero() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getIntStringReturnsZero.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            int testresult = main.getInt(10);
            assertEquals(-1, testresult);
        }
    }

    @Test
    void getIntLargerThanLengthReturnsZero() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getIntLargerThanRangeReturnsZero.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            int testresult = main.getInt(5);
            assertEquals(-1, testresult);
        }
    }

    @Test
    void getDouble() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getDouble.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            double testresult = main.getDouble();
            assertEquals(2.3, testresult);
        }
    }

    @Test
    void getString() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getString.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            String testresult = main.getString();
            assertEquals("Hello World", testresult);
        }
    }

    Repository mock=mock(Repository.class);
    @Test
    void writeTextFile() {
        String path = System.getProperty("user.home") //C:\Users\wumin_000\Desktop\testare\Utveckling av applikationer och tjänster\exerciese\projektuppgift\test\resources
                + java.io.File.separator + "Desktop"
                + java.io.File.separator + "testare"
                + java.io.File.separator + "Utveckling av applikationer och tjänster"
                + java.io.File.separator + "exerciese"
                + java.io.File.separator + "projektuppgift"
                + java.io.File.separator + "test"
                + java.io.File.separator + "resources"
                + java.io.File.separator + "writeTextFile.txt";
        java.io.File file = new java.io.File(path);
        try (FileWriter filewriter = new FileWriter(file)) {
            Main.WriteTextFile(mock, "the expected test");
            verify(mock).write( "the expected test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Printer mock_printer =mock(Printer.class);
    @Test
    void printCustomer() {
        Customer customer=new Customer("Min Wu", "Shanghai");
        ArrayList<Customer> customers=new ArrayList<>();
        customers.add(customer);
        Main.PrintCustomer(mock_printer, customers);
        verify(mock_printer).println_customer(customers);
    }

    @Test
    void printProduct() {
        Product product=new Drink("Milk", 10.5);
        ArrayList<Product> products=new ArrayList<>();
        products.add(product);
        Main.PrintProduct(mock_printer, products);
        verify(mock_printer).println_product(products);

    }


}