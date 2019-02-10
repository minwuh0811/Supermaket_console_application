import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void firstLettertoUpperCase() {
        String testInput="min Wu";
        String testresult=Main.FirstLettertoUpperCase(testInput);
        assertEquals("Min Wu", testresult);
    }

    @Test
    void isFirstLetterUppcaseReturnsTrue() {
        String testInput="Min Wu";
        boolean testresult=Main.isFirstLetterUppcase(testInput);
        assertTrue(testresult);
    }
    @Test
    void isFirstLetterUppcaseReturnsFalse() {
        String testInput="min Wu";
        boolean testresult=Main.isFirstLetterUppcase(testInput);
        assertFalse(testresult);
    }
    @Test
    void isFirstLetterUppcaseEmptyStringReturnsFalse() {
        String testInput="";
        boolean testresult=Main.isFirstLetterUppcase(testInput);
        assertFalse(testresult);
    }
    @Test
    void isFirstLetterUppcaseNullReturnsFalse() {
        String testInput=null;
        boolean testresult=Main.isFirstLetterUppcase(testInput);
        assertFalse(testresult);
    }

    @Test
    void getCustomerNameFirstLetterUppcase() throws IOException {
            try (InputStream inputStream = MainTest.class.getResourceAsStream("/input.txt")) {
                Scanner scanner = new Scanner(inputStream);
                Main main=new Main(scanner);
                String testresult=main.getCustomerName();
                assertEquals("Min Wu", testresult);
            }
        }
    @Test
    void getCustomerNameFirstLetterUppcaseEmptyReturnsFalse() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getCustomerNameEmptyReturnsFalsue.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main=new Main(scanner);
            String testresult=main.getCustomerName();
            assertEquals("",testresult);
        }
    }

    @Test
    void getIntStringReturnsZero() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getIntStringReturnsZero.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main=new Main(scanner);
            int testresult=main.getInt(10);
            assertEquals(0,testresult);
        }
    }
    @Test
    void getIntLargerThanLengthReturnsZero() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getIntLargerThanInputReturnsZero.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main=new Main(scanner);
            int testresult=main.getInt(5);
            assertEquals(0,testresult);
        }
    }
}