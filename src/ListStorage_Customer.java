import java.io.*;
import java.util.ArrayList;

public class ListStorage_Customer implements Storage_Customer {
    ArrayList<Customer> customers = new ArrayList<>();
    private String file_name;
    private String path;


    ListStorage_Customer(String file_name,String path) {
        this.file_name=file_name;
        this.path=path;
        LoadCustomerFile(file_name,path);
    }


    private void  LoadCustomerFile(String file_name, String path) {
        String file=file_name+".bin";
        path = path + java.io.File.separator + file;
        java.io.File file_Customer = new java.io.File(path);
        try (ObjectInputStream in =
                     new ObjectInputStream(new BufferedInputStream(new FileInputStream(file_Customer)))) {
            customers = (ArrayList<Customer>) in.readObject();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {

        }
        try {
            Customer.setCount(customers.size());
        } catch ( java.lang.IndexOutOfBoundsException e){
            Customer.setCount(0);
        }
    }

    private void close(){
        saveToCustomerFile(file_name,path);
//        saveToOrderSearchFile();
    }

    private void saveToCustomerFile(String file_name, String path) {
        String file1=file_name+".bin";
        String path_bin = path + java.io.File.separator + file1;
        java.io.File file_Customer = new java.io.File(path_bin);
        String file2=file_name+".txt";
        String path_txt = path + java.io.File.separator + file2;
        java.io.File file = new java.io.File(path_txt);
        int length=customers.size();
        String text="";
        for (int i=0; i<length; i++) {
            text+="" + customers.get(i).getCustomerID() + '\n'
                    + customers.get(i).getName() + '\n'
                    +customers.get(i).getCity() +'\n';
        }

        try (FileWriter filewriter = new FileWriter(file)) {
            Repository repository=new Repository_Class(filewriter);
            Main.WriteTextFile(repository,text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file_Customer)))) {
            out.writeObject(customers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
        saveToCustomerFile(file_name,path);
        close();
    }


    public Customer findCustomer(int customerID){

        for (Customer c : customers ) {
            if( c.getCustomerID()==customerID)
                return c;
        }
        return new Customer("NoOne","NoPlace");
    }
}
