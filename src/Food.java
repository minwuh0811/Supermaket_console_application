public class Food extends Product{
    private String producttype="Food";
    private String Unit="kr/kg";

    public Food(String productname,Double prices){
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
