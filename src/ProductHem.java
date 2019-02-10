import java.io.Serializable;

public class ProductHem extends Product implements Serializable {
    private Product product;
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ProductHem(Product product, double amount){
        this.product=product;
        this.amount=amount;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "ProductHem{" +
                "product=" + productname +
                ", amount=" + amount +
                '}';
    }
}
