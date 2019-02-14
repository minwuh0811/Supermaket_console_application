public class Fruit extends Product {
    private String producttype="Fruit";
    private String Unit="kr/kg";
    public static final long serialVersionUID =-6772929915109082697L;

    public Fruit(String productname,Double prices){
            super(productname,prices);
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

}
