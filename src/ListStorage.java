import java.io.*;
import java.util.ArrayList;



public class ListStorage implements Storage {
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Order> orders = new ArrayList<>();
    ArrayList<Order> ordersearches = new ArrayList<>();
    ListStorage() {
        LoadCustomerFile();
        LoadProductFile();
        LoadOrderFile();
    }

    private void  LoadCustomerFile() {
        String path = System.getProperty("user.home")
                + java.io.File.separator + "Desktop"
                + java.io.File.separator + "testare"
                + java.io.File.separator + "Utveckling av applikationer och tjänster"
                + java.io.File.separator + "exerciese"
                + java.io.File.separator + "projektuppgift"
                + java.io.File.separator + "src";
        path = path + java.io.File.separator + "Customer.bin";
        java.io.File file_Customer = new java.io.File(path);
        try (ObjectInputStream in =
                     new ObjectInputStream(new BufferedInputStream(new FileInputStream(file_Customer)))) {
            customers = (ArrayList<Customer>) in.readObject();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }
        try {
            Customer.setCount(customers.size());
        } catch ( java.lang.IndexOutOfBoundsException e){
            Customer.setCount(0);
        }
    }
    public void  LoadProductFile() {
        String path = System.getProperty("user.home")
                + java.io.File.separator + "Desktop"
                + java.io.File.separator + "testare"
                + java.io.File.separator + "Utveckling av applikationer och tjänster"
                + java.io.File.separator + "exerciese"
                + java.io.File.separator + "projektuppgift"
                + java.io.File.separator + "src";
        path = path + java.io.File.separator + "Product.bin";
        java.io.File file_Product = new java.io.File(path);
        try (ObjectInputStream in =
                     new ObjectInputStream(new BufferedInputStream(new FileInputStream(file_Product)))) {
            products = (ArrayList<Product>) in.readObject();
        } catch (FileNotFoundException e) {
            //On first start you will end up here. No file available.
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }
    }
    public void  LoadOrderFile() {
        String path = System.getProperty("user.home")
                + java.io.File.separator + "Desktop"
                + java.io.File.separator + "testare"
                + java.io.File.separator + "Utveckling av applikationer och tjänster"
                + java.io.File.separator + "exerciese"
                + java.io.File.separator + "projektuppgift"
                + java.io.File.separator + "src";
        path = path + java.io.File.separator + "Order.bin";
        java.io.File file_Order = new java.io.File(path);
        try (ObjectInputStream in =
                     new ObjectInputStream(new BufferedInputStream(new FileInputStream(file_Order)))) {
            orders = (ArrayList<Order>) in.readObject();
        } catch (FileNotFoundException e) {
            //On first start you will end up here. No file available.
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }
    }

    public void  LoadOrderSearchFile() {
        String path = System.getProperty("user.home")
                + java.io.File.separator + "Desktop"
                + java.io.File.separator + "testare"
                + java.io.File.separator + "Utveckling av applikationer och tjänster"
                + java.io.File.separator + "exerciese"
                + java.io.File.separator + "projektuppgift"
                + java.io.File.separator + "src";
        path = path + java.io.File.separator + "Order_Search.txt";
        java.io.File file_OrderSearch = new java.io.File(path);
        try (ObjectInputStream in =
                     new ObjectInputStream(new BufferedInputStream(new FileInputStream(file_OrderSearch)))) {
            ordersearches = (ArrayList<Order>) in.readObject();
        } catch (FileNotFoundException e) {
            //On first start you will end up here. No file available.
        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }
    }
    public void close(){
        saveToCustomerFile();
        saveToProductFile();
        saveToOrderFile();
//        saveToOrderSearchFile();
    }
    private void saveToCustomerFile() {
        String path = System.getProperty("user.home")
                + java.io.File.separator + "Desktop"
                + java.io.File.separator + "testare"
                + java.io.File.separator + "Utveckling av applikationer och tjänster"
                + java.io.File.separator + "exerciese"
                + java.io.File.separator + "projektuppgift"
                + java.io.File.separator + "src";
        String path_bin = path + java.io.File.separator + "Customer.bin";
        java.io.File file_Customer = new java.io.File(path_bin);
        String path_txt = path + java.io.File.separator + "Customer.txt";
        java.io.File file = new java.io.File(path_txt);
        int length=customers.size();
        String text="";
        for (int i=0; i<length; i++) {
            text+="" + customers.get(i).getCustomerID() + '\n'
            + customers.get(i).getName() + '\n'
                    +customers.get(i).getCity() +'\n';
        }
        WriteTextFile(file,text);
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file_Customer)))) {
            out.writeObject(customers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveToProductFile() {
        String path = System.getProperty("user.home")
                + java.io.File.separator + "Desktop"
                + java.io.File.separator + "testare"
                + java.io.File.separator + "Utveckling av applikationer och tjänster"
                + java.io.File.separator + "exerciese"
                + java.io.File.separator + "projektuppgift"
                + java.io.File.separator + "src";
        String path_bin = path + java.io.File.separator + "Product.bin";
        java.io.File file_Product = new java.io.File(path_bin);
        String path_txt = path + java.io.File.separator + "Product.txt";
        java.io.File file = new java.io.File(path_txt);
        int length=products.size();
        String text="";
        for (int i=0; i<length; i++) {
            text+="" + products.get(i).getProductname() + '\n'
                    + products.get(i).getPrices() + '\n';
        }
        WriteTextFile(file,text);
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file_Product)))) {
            out.writeObject(products);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveToOrderFile() {
        String path = System.getProperty("user.home")
                + java.io.File.separator + "Desktop"
                + java.io.File.separator + "testare"
                + java.io.File.separator + "Utveckling av applikationer och tjänster"
                + java.io.File.separator + "exerciese"
                + java.io.File.separator + "projektuppgift"
                + java.io.File.separator + "src";
        String path_bin = path + java.io.File.separator + "Order.bin";
        java.io.File file_Order = new java.io.File(path_bin);
        String path_txt = path + java.io.File.separator + "Order.txt";
        java.io.File file = new java.io.File(path_txt);
        int length=orders.size();
        String text="";
        for (int i=0; i<length; i++) {
            text+="CustomerID: " + orders.get(i).getCustomer().getCustomerID() + "  Customer Name: " + orders.get(i).getCustomer().getName()+ '\n'
                    + "  Product Name: "+orders.get(i).getProducthem().getProduct().getProductname()+ "  Amount: "+ orders.get(i).getProducthem().getAmount()
                    +"  Product Price: "+ orders.get(i).getProducthem().getProduct().getPrices()+ '\n';
        }
        WriteTextFile(file,text);
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file_Order)))) {
            out.writeObject(orders);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveToOrderSearchFile() {
        String path = System.getProperty("user.home")
                + java.io.File.separator + "Desktop"
                + java.io.File.separator + "testare"
                + java.io.File.separator + "Utveckling av applikationer och tjänster"
                + java.io.File.separator + "exerciese"
                + java.io.File.separator + "projektuppgift"
                + java.io.File.separator + "src";
        path = path + java.io.File.separator + "Order_Search.text";
        java.io.File file_OrderSearch = new java.io.File(path);
        int length=ordersearches.size();
        double sum=0;
        String text="CustomerID: " + ordersearches.get(0).getCustomer().getCustomerID() + "  Customer Name: " + ordersearches.get(0).getCustomer().getName() + '\n';
        for (int i=0; i<length; i++) {
            sum+=ordersearches.get(i).getProducthem().getAmount()*ordersearches.get(i).getProducthem().getProduct().getPrices();
            text+="Product Name: "+ordersearches.get(i).getProducthem().getProduct().getProductname()+ "  Amount: "+ ordersearches.get(i).getProducthem().getAmount()
                    +"  Product Price: "+ ordersearches.get(i).getProducthem().getProduct().getPrices()+ '\n';
        }
        text+= "Total Payment: " + sum +'\n';
        WriteTextFile(file_OrderSearch,text);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
        saveToCustomerFile();
    }
    public void PrintCustomer() {
        int length=customers.size();
        for (int i=0; i< length; i++) {
            System.out.println("CustomerID: "+ customers.get(i).getCustomerID()+ "  Customer Name: " +customers.get(i).getName()+ "  Customer City "+customers.get(i).getCity());
        }
    }
    public Customer findCustomer(int customerID){
        for (Customer c : customers ) {
            if( c.getCustomerID()==customerID)
                return c;
        }
        return new Customer("NoOne","NoPlace");
    }

    public void addProduct(Product product){
        products.add(product);
        saveToProductFile();
    }

    public void PrintProduct() {
        int length=products.size();
        for (int i=0; i< length; i++) {
            System.out.println("No."+ i+ " Product Name: "+ products.get(i).getProductname() + " Product Price: " +products.get(i).getPrices());
        }
    }
    public Product findProduct(int input) {
//        System.out.println(products.get(input));
        return products.get(input);
    }

    public void addOrder(Order order) {
        orders.add(order);
        saveToOrderFile();
    }

    public void addOrderSearch(Order order) {
        ordersearches.add(order);
        saveToOrderSearchFile();
    }

    public void findOrder(int customerID){
        for (Order c : orders ) {
            if( c.getCustomer().getCustomerID()==customerID) {
                addOrderSearch(c);
            }
        }
    }
    public static void WriteTextFile(java.io.File file, String text) {
        try (FileWriter filewriter = new FileWriter(file)) {
            filewriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

