public class ProductHem extends Product {
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

    @Override
    public String toString() {
        return "ProductHem{" +
                "product=" + productname +
                ", amount=" + amount +
                '}';
    }
}
