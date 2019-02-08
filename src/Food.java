public class Food extends Product{
    private String producttype="Food";
    private String Unit="kr/kg";

    public Food(String productname,Double prices){
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
        return "Food{" +
                "producttype='" + producttype + '\'' +
                ", Unit='" + Unit + '\'' +
                ", productname='" + productname + '\'' +
                ", prices=" + prices +
                '}';
    }
}
