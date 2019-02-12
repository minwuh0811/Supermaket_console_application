import java.io.*;
import java.util.ArrayList;

public class ListStorage_Product implements Storage_Product {
    ArrayList<Product> products = new ArrayList<>();
    private String file_name;
    private String path;

    ListStorage_Product(String file_name,String path) {
        this.file_name=file_name;
        this.path=path;
        LoadProductFile(file_name,path);
    }
    public void  LoadProductFile(String file_name,String path) {
        String file=file_name+".bin";
        path = path + java.io.File.separator + file;
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
    private void close(){
        saveToProductFile(file_name,path);
//        saveToOrderSearchFile();
    }
    public void saveToProductFile(String file_name,String path) {
        String file1=file_name+".bin";
        String path_bin = path + java.io.File.separator + file1;
        java.io.File file_Product = new java.io.File(path_bin);
        String file2=file_name+".txt";
        String path_txt = path + java.io.File.separator + file2;
        java.io.File file = new java.io.File(path_txt);
        int length=products.size();
        String text="";
        for (int i=0; i<length; i++) {
            text+="" + products.get(i).getProductname() + '\n'
                    + products.get(i).getPrices() + '\n';
        }
        try (FileWriter filewriter = new FileWriter(file)) {
            Repository repository=new Repository_Class(filewriter);
            Main main=new Main(repository);
            main.WriteTextFile(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file_Product)))) {
            out.writeObject(products);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addProduct(Product product){
        products.add(product);
        saveToProductFile(file_name,path);
        close();
    }

    public void PrintProduct() {
        int length=products.size();
        for (int i=0; i< length; i++) {
            System.out.println("No."+ i
                    + " Product Name: " + products.get(i).getProductname()
                   + " Product Price: " +products.get(i).getPrices());
        }
    }
    public Product findProduct(int ID) {

//        System.out.println(products.get(input));
        return products.get(ID);
    }

}
