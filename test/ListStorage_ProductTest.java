import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ListStorage_ProductTest {
    String path = System.getProperty("user.home") //C:\Users\wumin_000\Desktop\testare\Utveckling av applikationer och tjänster\exerciese\projektuppgift\test\resources
            + java.io.File.separator + "Desktop"
            + java.io.File.separator + "testare"
            + java.io.File.separator + "Utveckling av applikationer och tjänster"
            + java.io.File.separator + "exerciese"
            + java.io.File.separator + "projektuppgift"
            + java.io.File.separator + "test"
            + java.io.File.separator + "resources";

    @Test
    void addProduct() {
        ListStorage_Product storage_product = new ListStorage_Product("Product_test", path);
        int start = storage_product.products.size();
        storage_product.addProduct(new Product());
        assertEquals(start + 1, storage_product.products.size());
    }

    @Test
    void findProduct() {
        ListStorage_Product storage_product = new ListStorage_Product("Product_test", path);
            Product product_find = storage_product.findProduct(0);
            String name = product_find.getProductname();
            assertEquals("Apple", name);
        }
    }
