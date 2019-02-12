import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.module.ResolutionException;
import java.util.NoSuchElementException;
import java.util.Scanner;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MainTest {
    @Test
    void firstLettertoUpperCase() {
        String testInput = "min Wu";
        String testresult = Main.FirstLettertoUpperCase(testInput);
        assertEquals("Min Wu", testresult);
    }

    @Test
    void isFirstLetterUppcaseReturnsTrue() {
        String testInput = "Min Wu";
        boolean testresult = Main.isFirstLetterUppcase(testInput);
        assertTrue(testresult);
    }

    @Test
    void isFirstLetterUppcaseReturnsFalse() {
        String testInput = "min Wu";
        boolean testresult = Main.isFirstLetterUppcase(testInput);
        assertFalse(testresult);
    }

    @Test
    void isFirstLetterUppcaseEmptyStringReturnsFalse() {
        String testInput = "";
        boolean testresult = Main.isFirstLetterUppcase(testInput);
        assertFalse(testresult);
    }

    @Test
    void isFirstLetterUppcaseNullReturnsFalse() {
        String testInput = null;
        boolean testresult = Main.isFirstLetterUppcase(testInput);
        assertFalse(testresult);
    }

    @Test
    void getCustomerNameFirstLetterUppcase() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/LowercaseToUppcase.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            String testresult = main.getCustomerName();
            assertEquals("Min Wu", testresult);
        }
    }

    @Test
    void getCustomerName() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getCustomerName.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            String testresult = main.getCustomerName();
            assertEquals("Min Wu", testresult);
        }
    }

    @Test
    void getCustomerNameEmptyReturnsException() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getCustomerNameEmpty.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            assertThrows(NoSuchElementException.class, () -> main.getCustomerName());
        }
    }

    @Test
    void getCustomerNameIntReturnsEmpty() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getCustomerNameIntReturnsEmpty.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            assertEquals("", main.getCustomerName());
        }
    }

    @Test
    void getInt() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getInt.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            int testresult = main.getInt(11);
            assertEquals(2, testresult);
        }
    }

    @Test
    void getIntStringReturnsZero() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getIntStringReturnsZero.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            int testresult = main.getInt(10);
            assertEquals(-1, testresult);
        }
    }

    @Test
    void getIntLargerThanLengthReturnsZero() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getIntLargerThanRangeReturnsZero.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            int testresult = main.getInt(5);
            assertEquals(-1, testresult);
        }
    }

    @Test
    void getDouble() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getDouble.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            double testresult = main.getDouble();
            assertEquals(2.3, testresult);
        }
    }

    @Test
    void getString() throws IOException {
        try (InputStream inputStream = MainTest.class.getResourceAsStream("/getString.txt")) {
            Scanner scanner = new Scanner(inputStream);
            Main main = new Main(scanner);
            String testresult = main.getString();
            assertEquals("Hello World", testresult);
        }
    }


}