import java.awt.geom.IllegalPathStateException;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.atomic.DoubleAccumulator;

public class Main {
    private static Scanner sc;
    public static void setSc(Scanner sc) {
        Main.sc = sc;
    }
    public Main (Scanner sc) {
        this.sc=sc;
    }
    public static void main(String[] args) {
        Main main = new Main(new Scanner(System.in));
        ListStorage storage=new ListStorage();
        int tal = 0;
        while (true) {
            do {
                System.out.println("What do you want to do? Type 0: CustomerRegister, Type 1: Add New product, Type 2 Shoppingcart, Type 3: Check Customer_shoppingcart, Type 4: Quit");
                tal = main.getInt(5);
            } while (tal == 0);
            String name1 = main.getString();
            switch (tal) {
                case 0:
                    String customer_name = "";
                    do {
                        System.out.println("Enter a new Customer: ");
                        customer_name = main.getCustomerName();
                    } while (customer_name.equals(""));
                    System.out.println("Enter the Customer City");
                    String customer_city = main.getString();
                    Customer new_customer = new Customer(customer_name, customer_city);
                    storage.addCustomer(new_customer);
                    storage.close();
                    break;
                case 1:
                    System.out.println("Please send in a new product name");
                    String product_name = main.getString();
                    System.out.println("Please send in the price kr/liter or kr/kg");
                    double product_price = main.getDouble();
                    int product_type = 0;
                    do {
                        System.out.println("Please send in the type of the product. Type 0: Fruit, Type 1: Food, Type 2: Drink, Type 3: Vegetable");
                        product_type = main.getInt(4);
                    } while (product_type == 0);
                    switch (product_type) {
                        case 0:
                            storage.addProduct(new Fruit(product_name, product_price));
                            break;
                        case 1:
                            storage.addProduct(new Food(product_name, product_price));
                            break;
                        case 2:
                            storage.addProduct( new Drink(product_name, product_price));
                            break;
                        case 3:
                            storage.addProduct(new Vegetable(product_name, product_price));
                            break;
                    }
                    storage.close();
                    break;
                case 2:
                    storage.PrintCustomer();
                    System.out.println("Enter Customer ID: ");
                    int CustomerID=main.getInt(storage.customers.size());
                    Customer customer_find=storage.findCustomer(CustomerID);
                    storage.PrintProduct();
                    System.out.println("Enter Product: ");
                    int productID=main.getInt(storage.products.size());
                    Product product_find=storage.findProduct(productID);
                    System.out.println(product_find);
                    System.out.println("Enter amount need: ");
                    double amount=main.getDouble();
                    ProductHem producthem=new ProductHem(product_find,amount);
                    Order order=new Order(customer_find,producthem);
                    storage.addOrder(order);
                    storage.close();
                    break;
                case 3:
                    storage.PrintCustomer();
                    System.out.println("Enter Customer ID: ");
                    int ID=main.getInt(storage.customers.size());
                    storage.findOrder(ID);
                    break;
                case 4:
                    return;
            }
        }
    }

    public static int getInt(int number) {
        int tal1 = 0;
        try {
            tal1 = sc.nextInt();
            if (tal1 < number && tal1 >= 0 ) {
                return tal1;
            } else {
                System.out.println("Felaktig inmatning! \nTry again!!");
                return 0;
            }
        } catch (InputMismatchException e) {
            System.out.println("Felaktig inmatning! \nTry again!!");
            sc.nextLine();
            return tal1;
        }
    }
    public static double getDouble() {
        return sc.nextDouble();
    }
    public static String getCustomerName() {
        String name = "";
        try {
            sc.nextInt();
            System.out.println("Name must be String type");
            return "";
        } catch (InputMismatchException e) {
            try {
                name = sc.nextLine();
                if (isFirstLetterUppcase(name)) {
                   return name;
                } else {
                    name = FirstLettertoUpperCase(name);
                   return name;
               }

            } catch (NoSuchElementException f) {
                System.out.println("Customer Name can not empty");
                return "";
            }
        }
    }
    public static String FirstLettertoUpperCase(String input){
        String First= input.substring(0,1).toUpperCase();
//        String rest=input.substring(1).toLowerCase();
        String rest=input.substring(1);
          return First+rest;
    }
    public static boolean isFirstLetterUppcase(String input){
        if (input==null||input.length()<1)
            return false;
        if (Character.isUpperCase(input.codePointAt(0))) {
                 return true;
                }
                else {return false;}

    }
    public static String getString() {
        return sc.nextLine();
    }
}






