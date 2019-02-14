import java.io.*;
import java.util.ArrayList;

public class ListStorage_Order implements Storage_Order {
    ArrayList<Order> orders = new ArrayList<>();
    ArrayList<Order> ordersearches = new ArrayList<>();
    private String file_name;
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    ListStorage_Order(String file_name, String path) {
        this.file_name=file_name;
        this.path=path;
        LoadOrderFile(file_name,path);
    }


    public void LoadOrderFile(String file_name,String path) {
        String file=file_name+".bin";
        path = path + java.io.File.separator + file;
        java.io.File file_Order = new java.io.File(path);
        try (ObjectInputStream in =
                     new ObjectInputStream(new BufferedInputStream(new FileInputStream(file_Order)))) {
            orders = (ArrayList<Order>) in.readObject();
        } catch (FileNotFoundException e) {
            //On first start you will end up here. No file available.
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {

        }
    }

    private void close() {
        saveToOrderFile(file_name,path);
    }

    private void saveToOrderFile(String file_name,String path) {
        String file1=file_name+".bin";
        String path_bin = path + java.io.File.separator + file1;
        java.io.File file_Order = new java.io.File(path_bin);
        String file2=file_name+".txt";
        String path_txt = path + java.io.File.separator + file2;
        java.io.File file = new java.io.File(path_txt);
        int length=orders.size();
        String text="CustomerID" +'\t'+ "Customer Name" +'\t' + "Product Name" +'\t' + "Amount" +'\t' + "Product Price" +'\t'+'\n';
        for (int i=0; i<length; i++) {
            text+="CustomerID: " + orders.get(i).getCustomer().getCustomerID() + "  "
           + "Customer Name:  " + orders.get(i).getCustomer().getName()+ "  "
            + "Product Name: "        +orders.get(i).getProducthem().getProduct().getProductname() + "  "
             + "Amount: "      + orders.get(i).getProducthem().getAmount() + "  "
               +"Product Price:  "     + orders.get(i).getProducthem().getProduct().getPrices()+'\n';
        }
        try (FileWriter filewriter = new FileWriter(file)) {
            Repository repository=new Repository_Class(filewriter);
            Main.WriteTextFile(repository,text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file_Order)))) {
            out.writeObject(orders);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addOrder(Order order) {
        orders.add(order);
        saveToOrderFile(file_name,path);
        close();
    }

    private void saveToOrderSearchFile(String file_name,String path) {
        String file=file_name+"_Search.txt";
        path = path + java.io.File.separator + file;
        java.io.File file_OrderSearch = new java.io.File(path);
        System.out.println(path);
        int length=ordersearches.size();
        double sum=0;
        String text="CustomerID: " + ordersearches.get(0).getCustomer().getCustomerID()
                + "  Customer Name: " + ordersearches.get(0).getCustomer().getName() + '\n';
        for (int i=0; i<length; i++) {
            sum+=ordersearches.get(i).getProducthem().getAmount()*ordersearches.get(i).getProducthem().getProduct().getPrices();
            text+="Product Name: "+ordersearches.get(i).getProducthem().getProduct().getProductname()
                    + "  Amount: "+ ordersearches.get(i).getProducthem().getAmount()
                    +"  Product Price: "+ ordersearches.get(i).getProducthem().getProduct().getPrices()+ '\n';
        }
        text+= "Total Payment: " + sum +'\n';
        try (FileWriter filewriter = new FileWriter(file_OrderSearch)) {
            Repository repository=new Repository_Class(filewriter);
            Main.WriteTextFile(repository,text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addOrderSearch(Order order) {
        ordersearches.add(order);
        saveToOrderSearchFile(file_name,path);

    }
    public ArrayList<Order> findOrder(int customerID){
        for (Order c : orders ) {
            if( c.getCustomer().getCustomerID()==customerID) {
                addOrderSearch(c);
            }
        }
        close();
        return ordersearches;

    }
}
