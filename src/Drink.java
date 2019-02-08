public class Drink extends Product {
    private String producttype="Drink";
    private String Unit="kr/liter";

    public Drink(String productname,Double prices){
        super();
        this.productname=productname;
        this.prices=prices;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    @Override
    public String getProductname() {
        return super.productname;
    }
    @Override
    public double getPrices() {
        return super.prices;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "producttype='" + producttype + '\'' +
                ", Unit='" + Unit + '\'' +
                ", productname='" + productname + '\'' +
                ", prices=" + prices +
                '}';
    }
}
