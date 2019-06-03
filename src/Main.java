import java.util.*;

public class Main {
    private static Scanner sc;

    public static void setSc(Scanner sc) {
        Main.sc = sc;
    }

    public Main(Scanner sc) {
        this.sc = sc;
    }


    public static void main(String[] args) {
        Main main = new Main(new Scanner(System.in));
        Printer pc=new printerClass();
//        String path = System.getProperty("user.home")
        String path= "D:"
                + java.io.File.separator + "testare"
                + java.io.File.separator + "Utveckling av applikationer och tjänster"
                + java.io.File.separator + "exerciese"
                + java.io.File.separator + "projektuppgift"
                + java.io.File.separator + "src";

        ListStorage_Customer storage_customer = new ListStorage_Customer("Customer", path);
        ListStorage_Product storage_product = new ListStorage_Product("Product", path);
        ListStorage_Order storage_order = new ListStorage_Order("Order", path);

        int tal = -1;
        while (true) {
            do {
                System.out.println("What do you want to do? Type 0: CustomerRegister, Type 1: Add New product, Type 2 Shoppingcart, Type 3: Check Customer_shoppingcart, Type 4: CustomerList, Type 5: ProductList, Type 6: Quit");
                tal = main.getInt(7);
            } while (tal == -1);
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
                    storage_customer.addCustomer(new_customer);
                    break;
                case 1:
                    System.out.println("Please send in a new product name");
                    String product_name = main.getString();
                    System.out.println("Please send in the price kr/liter or kr/kg");
                    double product_price = main.getDouble();
                    int product_type = -1;
                    do {
                        System.out.println("Please send in the type of the product. Type 0: Fruit, Type 1: Food, Type 2: Drink, Type 3: Vegetable");
                        product_type = main.getInt(4);
                    } while (product_type == -1);
                    switch (product_type) {
                        case 0:
                            storage_product.addProduct(new Fruit(product_name, product_price));
                            break;
                        case 1:
                            storage_product.addProduct(new Food(product_name, product_price));
                            break;
                        case 2:
                            storage_product.addProduct(new Drink(product_name, product_price));
                            break;
                        case 3:
                            storage_product.addProduct(new Vegetable(product_name, product_price));
                            break;
                    }
                    break;
                case 2:
                    PrintCustomer(pc, storage_customer.customers);
                    System.out.println("Enter Customer ID: ");
                    int customerID = Main.getInt(storage_customer.customers.size());
                    Customer customer_find = storage_customer.findCustomer(customerID);
                    PrintProduct(pc,storage_product.products);
                    System.out.println("Enter Product: ");
                    int input = Main.getInt(storage_product.products.size());
                    Product product_find = storage_product.findProduct(input);
                    System.out.println("Enter amount need: ");
                    double amount = main.getDouble();
                    ProductHem producthem = new ProductHem(product_find, amount);
                    Order order = new Order(customer_find, producthem);
                    storage_order.addOrder(order);
                    break;
                case 3:
                    PrintCustomer(pc,storage_customer.customers);
                    System.out.println("Enter Customer ID: ");
                    int ID = main.getInt(storage_customer.customers.size());
                    storage_order.findOrder(ID);
                    break;
                case 4:
                    PrintCustomer(pc, storage_customer.customers);
                    break;
                case 5:
                    PrintProduct(pc,storage_product.products);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Didn't get any Number");
                    return;
            }
        }
    }

    public static int getInt(int number) {
        int tal1 = -1;
        try {
            tal1 = sc.nextInt();
            if (tal1 < number && tal1 >= 0) {
                return tal1;
            } else {
                System.out.println("Felaktig inmatning! \nTry again!!");
                return -1;
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
            int interger = sc.nextInt();
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

    public static String FirstLettertoUpperCase(String input) {
        String First = input.substring(0, 1).toUpperCase();
//        String rest=input.substring(1).toLowerCase();
        String rest = input.substring(1);
        return First + rest;
    }

    public static boolean isFirstLetterUppcase(String input) {
        if (input == null || input.length() < 1)
            return false;
        if (Character.isUpperCase(input.codePointAt(0))) {
            return true;
        } else {
            return false;
        }

    }

    public static String getString() {
        return sc.nextLine();
    }

    public static void WriteTextFile(Repository repository, String text) {
        repository.write(text);
    }


    public static void PrintCustomer(Printer printer, ArrayList<Customer> customers) {
            printer.println_customer(customers);
    }
    public static void PrintProduct(Printer printer, ArrayList<Product> products){
        printer.println_product(products);
    }
}





