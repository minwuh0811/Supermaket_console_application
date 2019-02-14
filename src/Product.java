import java.io.Serializable;

public class Product implements Serializable {
    protected String productname;
    protected double prices;
    public static final long serialVersionUID =3977164360091333385L;
    public Product(){}

    public Product(String productname,double prices) {
        this.productname=productname;
        this.prices=prices;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }



 }





