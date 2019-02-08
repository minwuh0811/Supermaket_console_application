import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.DoubleAccumulator;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static CustomerRegister customerlist;
    private static ProductList productlist;

    public static void main(String[] args) {
        CustomerRegister customerlist = new CustomerRegister();
        ProductList productlist = new ProductList();
        Orders orderlist = new Orders();
        int tal = 0;
        String path = System.getProperty("user.home")
                + java.io.File.separator + "Desktop"
                + java.io.File.separator + "testare"
                + java.io.File.separator + "Utveckling av applikationer och tjänster"
                + java.io.File.separator + "exerciese"
                + java.io.File.separator + "projektuppgift"
                + java.io.File.separator + "src";
        String path1 = path + java.io.File.separator + "Customer.txt";
        java.io.File file_Customer = new java.io.File(path1);
        String path2 = path + java.io.File.separator + "Product.txt";
        java.io.File file_Product = new java.io.File(path2);
        String path3 = path + java.io.File.separator + "Order.txt";
        java.io.File file_Order = new java.io.File(path3);
        String path4 = path + java.io.File.separator + "Order_Search.txt";
        java.io.File file_OrderSearch = new java.io.File(path4);
        while (true) {
            do {
                System.out.println("What do you want to do? Type 1: CustomerRegister, Type 2: Add New product, Type 3 Shoppingcart, Type 4: Check Customer_shoppingcart, Type 5: Quit");
                tal = Main.getInt(5);
            } while (tal == 0);
            String name1 = Main.getString();
            switch (tal) {
                case 1:
                    String Customeroutput = "";
                    String customer_name = "None";
                    do {
                        System.out.println("Please send in a new Customer name");
                        customer_name = Main.getCustomerName();
                    } while (customer_name == "None");
                    System.out.println("Please send in a mew Customer City");
                    String customer_city = Main.getString();
                    Customer new_customer = new Customer(customer_name, customer_city);
                    Customeroutput += ""+ customer_name + '\n' + customer_city + '\n' + new_customer.getCustomerID() + '\n' + '\n';
                    if (Customeroutput != null) {
                        File.WriteTextFile(file_Customer, Customeroutput);
                    }
                    break;
                case 2:
                    String productoutput = "";
                    System.out.println("Please send in a new product name");
                    String product_name = Main.getString();
                    System.out.println("Please send in the price kr/liter or kr/kg");
                    double product_price = Main.getDouble();
                    productoutput += product_name + '\n' +  product_price + '\n';
                    int product_type = 0;
                    do {
                        System.out.println("Please send in the type of the product. Type 1: Fruit, Type 2: Food, Type 3: Drink, Type 4: Vegetable");
                        product_type = Main.getInt(4);
                    } while (product_type == 0);
                    switch (product_type) {
                        case 1:
                            productoutput +=   "kr/kg" + '\n' + "Fruit" + '\n' + '\n';
                            break;
                        case 2:
                            productoutput +=   "kr/liter" + '\n' + "Food" + '\n' + '\n';
                            break;
                        case 3:
                            productoutput +=   "kr/kg" + '\n' + "Drink" + '\n' + '\n';
                            break;
                        case 4:
                            productoutput +=  "kr/kg" + '\n' + "Vegetable" + '\n' + '\n';
                            break;
                    }
                    if (productoutput != null) {
                        File.WriteTextFile(file_Product, productoutput);
                    }
                    break;

                case 3:
                    String orderoutput = "";
                    ArrayList<String> ProductList = File.readTextFileFromAbsolutePath(file_Product);
                    CreateCustomerList(customerlist, file_Customer);
                    PrintCustomerList(customerlist);
                    int CustomerIndex = CreateIndex(customerlist);
                    orderoutput += customerlist.getCustomers().get(CustomerIndex - 1).getCustomerID() + '\n'
                            + customerlist.getCustomers().get(CustomerIndex - 1).getName() + '\n';
                    int length_Product = ProductList.size();
                    for (int j = 1; j < length_Product; j += 5) {
                        product_name = ProductList.get(j);
                        double price = Double.parseDouble(ProductList.get(j + 1));
                        String type = ProductList.get(j + 3);
                        Product.Product_level level = Product.Product_level.valueOf(type);
                        switch (level) {
                            case Fruit:
                                CreateFruit(productlist, product_name, price);
                                break;
                            case Food:
                                CreateFood(productlist, product_name, price);
                                break;
                            case Drink:
                                CreateDrink(productlist, product_name, price);
                                break;
                            case Vegetable:
                                CreateVegetable(productlist, product_name, price);
                                break;
                        }
                    }
                    PrintProductList(productlist);
                    int Productindex=ProductIndex(productlist);
                    System.out.println("Please send in the amount you need.");
                    double amount = Main.getDouble();
                    System.out.println("Please send in the Date.");
                    String sp = Main.getString();
                    String Date = Main.getString();
                    orderoutput += "" + productlist.getProductlist().get(Productindex - 1).getProductname() + '\n'
                            + productlist.getProductlist().get(Productindex - 1).getPrices() + '\n'
                            + amount + '\n'
                            + Date + '\n' + '\n';
                    String order = orderoutput;
                    if (order != null) {
                        File.WriteTextFile(file_Order, order);
                    }
                    return;
                case 4:
                    String Order_search = "";
                    ArrayList<String> OrderList = File.readTextFileFromAbsolutePath(file_Order);
                    CreateCustomerList(customerlist, file_Customer);
                    double Total_payment = 0;
                    int length3 = OrderList.size();
                    PrintCustomerList(customerlist);
                    CustomerIndex = CreateIndex(customerlist);
                    Order_search += customerlist.getCustomers().get(CustomerIndex- 1).getCustomerID() + " " + customerlist.getCustomers().get(CustomerIndex - 1).getName() + '\n';
                    for (int i = 1; i < length3; i += 7) {
                        if (OrderList.get(i).equals(customerlist.getCustomers().get(CustomerIndex - 1).getCustomerID())) {
                            Order_search += "" + OrderList.get(i + 2) + " " + OrderList.get(i + 3) + " " + OrderList.get(i + 4) + " " + OrderList.get(i + 5) + '\n';
                            Total_payment += Double.parseDouble(OrderList.get(i + 3)) * Double.parseDouble(OrderList.get(i + 4));
                        }
                    }
                    Order_search += "Total_payment: " + Total_payment + '\n' + '\n';
                    if (Order_search != null) {
                        File.WriteTextFile(file_OrderSearch, Order_search);
                    }
                    return;
                case 5:
                    return;
            }
        }
    }

    private static void CreateVegetable(ProductList productlist, String product_name, double price) {
        Vegetable new_veg = new Vegetable(product_name, price);
        productlist.productlist_add(new_veg);
    }
    private static void CreateDrink(ProductList productlist, String product_name, double price) {
        Drink new_drink = new Drink(product_name, price);
        productlist.productlist_add(new_drink);
    }
    private static void CreateFood(ProductList productlist, String product_name, double price) {
        Food new_food = new Food(product_name, price);
        productlist.productlist_add(new_food);
    }
    private static void CreateFruit(ProductList productlist, String product_name, double price) {
        Fruit new_fruit = new Fruit(product_name, price);
        productlist.productlist_add(new_fruit);
    }
    public static int getInt(int number) {
        int tal1 = 0;
        try {
            tal1 = sc.nextInt();
            if (tal1 <= number) {
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
    public static int getIndex(int Index) {
        int tal2 = 0;
        try {
            tal2 = sc.nextInt();
            if (tal2 <= Index && tal2 > 0) {
                return tal2;
            } else {
                System.out.println("Felaktig inmatning! \nTry again!!");
                return 0;
            }
        } catch (InputMismatchException e) {
            System.out.println("Felaktig inmatning! \nTry again!!");
            sc.nextLine();
            return tal2;
        }

    }
    public static double getDouble() {
        return sc.nextDouble();
    }
    public static String getCustomerName() {
        String name = "None";
        try {
            name = sc.nextLine();
            if (Character.isUpperCase(name.charAt(0)) == false) {
                System.out.println("Fel inmatning name" + name + "!." + "Du måste skriva name med stor första bokstav!!");
                return "None";
            } else {
                return name;
            }
        } catch (InputMismatchException e) {
            System.out.println("Fel inmatning name" + name + "!." + "Du måste skriva name med stor första bokstav!!");
            return "None";
        }
    }
    public static String getString() {
        return sc.nextLine();
    }
    private static void PrintCustomerList(CustomerRegister customerlist) {
        int length = customerlist.getCustomers().size();
        for (int i = 0; i < length; i++) {
            int n = i + 1;
            System.out.println("No. " + n + " CustomerID: " + customerlist.getCustomers().get(i).getCustomerID() + " Customer Name: " + customerlist.getCustomers().get(i).getName() + " Customer City: " + customerlist.getCustomers().get(i).getCity() + "\n");
        }
    }
    private static void CreateCustomerList(CustomerRegister customerlist, java.io.File file) {
        ArrayList<String> CustomerList = File.readTextFileFromAbsolutePath(file);
        int length_Customer = CustomerList.size();
        for (int i = 1; i < length_Customer; i += 4) {
            Customer customer = new Customer(CustomerList.get(i), CustomerList.get(i + 1), CustomerList.get(i + 2));
            customerlist.Customer_add(customer);
        }

    }
    private static int CreateIndex(CustomerRegister customerlist) {
        int length = customerlist.getCustomers().size();
        int index = 0;
        do {
            System.out.println("Please send in the No. from the customerlist");
            index = Main.getIndex(length);
        } while (index == 0);
        return index;
    }
    private static void PrintProductList(ProductList productlist){
        int length = productlist.getProductlist().size();
        for (int j = 0; j < length; j++) {
            int n = j + 1;
            System.out.println("No. " + n + " Product Name: " + productlist.getProductlist().get(j).getProductname() + " Product Prices: " + productlist.getProductlist().get(j).getPrices() + "\n");
        }

    }
    private static int ProductIndex(ProductList productlist){
        int length=productlist.getProductlist().size();
        int index=0;
        do {
            System.out.println("Please send in the Product from the productlist");
            index = Main.getIndex(length);
        } while (index == 0);
        return index;
    }
}






