import java.util.ArrayList;
import java.lang.NullPointerException;

public class Order {
    private Customer customer;
    private ArrayList<ProductHem> producthems;
//    private HashMap<Customer, ArrayList<Product>> prodcutshash = new HashMap<>();
    private ProductHem producthem;


    public ArrayList<ProductHem> getProducthems() {
        return producthems;
    }

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
    public ArrayList<ProductHem> ProductHems_add(ProductHem producthem) {
        producthems.add(producthem);
        return producthems;
    }


//    public HashMap<Customer, ArrayList<Product>> getProdcutshash() {
//        return prodcutshash;
//    }
//
//    @Override
//    public String toString() {
//        return "Order{" +
//                "prodcutshash=" + prodcutshash +
//                '}';
//    }
//
//    public HashMap Customer_Order(Customer customer, Product product){
//        if (prodcutshash.get(customer)==null) {
//            ArrayList product_new= new ArrayList();
//            product_new.add(product);
//            prodcutshash.put(customer, product_new);
//        }
//        else {prodcutshash.get(customer).add(product);}
//        return prodcutshash;
//    }
//
//
//

}
