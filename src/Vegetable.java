public class Vegetable extends Product {
    private String producttype="Vegetable";
    private String Unit="kr/liter";

    public Vegetable(String productname,Double prices){
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
