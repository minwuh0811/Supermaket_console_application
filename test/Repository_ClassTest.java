import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.awt.image.RescaleOp;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class Repository_ClassTest  {
    Repository mock=mock(Repository.class);
    Main main=new Main(mock);


    @Test
    void writeTest() {
        main.setOut(mock);
            String path = System.getProperty("user.home") //C:\Users\wumin_000\Desktop\testare\Utveckling av applikationer och tjänster\exerciese\projektuppgift\test\resources
                    + java.io.File.separator + "Desktop"
                    + java.io.File.separator + "testare"
                    + java.io.File.separator + "Utveckling av applikationer och tjänster"
                    + java.io.File.separator + "exerciese"
                    + java.io.File.separator + "projektuppgift"
                    + java.io.File.separator + "test"
                    + java.io.File.separator + "resources"
                    + java.io.File.separator + "writeTextFile.txt";
            java.io.File file = new java.io.File(path);
            try (FileWriter filewriter = new FileWriter(file)) {
                main.WriteTextFile( "the expected test");
                verify(mock).write( "the expected test");
            } catch (IOException e) {
               e.printStackTrace();
            }
        }
   }


