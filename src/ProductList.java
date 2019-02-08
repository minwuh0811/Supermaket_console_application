import java.util.ArrayList;

public class ProductList {
    private ArrayList<Product> productlist = new ArrayList();

    public ArrayList<Product> getProductlist() {
        return productlist;
    }

    public ArrayList productlist_add(Product product) {
        productlist.add(product);
        return productlist;
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "productlist=" + productlist +
                '}';
    }
}
