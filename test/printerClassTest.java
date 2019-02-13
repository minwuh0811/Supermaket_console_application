import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class printerClassTest {

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