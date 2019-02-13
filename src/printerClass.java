import java.util.ArrayList;

public class printerClass implements Printer {

    public void println_customer(ArrayList<Customer> customers) {
        int length = customers.size();
        for (int i = 0; i < length; i++) {
            System.out.println("CustomerID: " + customers.get(i).getCustomerID()
                    + "  Customer Name: " + customers.get(i).getName()
                    + "  Customer City " + customers.get(i).getCity());
        }
    }

    public void println_product(ArrayList<Product> products){
        int length=products.size();
        for (int i=0; i< length; i++) {
            System.out.println("No."+ i
                    + " Product Name: " + products.get(i).getProductname()
                    + " Product Price: " +products.get(i).getPrices());
        }
    }





}
