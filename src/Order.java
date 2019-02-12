import java.io.Serializable;
import java.util.ArrayList;
import java.lang.NullPointerException;

public class Order implements Serializable {
    private Customer customer;
    private ProductHem producthem;

    public Customer getCustomer() {
        return customer;
    }

    public ProductHem getProducthem() {
        return producthem;
    }

    public Order(Customer customer, ProductHem producthem) {
        this.customer=customer;
        this.producthem=producthem;
    }
    public Order(){}
}
