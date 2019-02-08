import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class File {


    public static ArrayList<String> readTextFileFromAbsolutePath(java.io.File file) {
        ArrayList<String> arraylist = new ArrayList();
        try {
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
//                System.out.println(line);
                arraylist.add(line);
            }
            scanner.close();// FileRead must have close()

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return arraylist;
    }


    public static void WriteTextFile(java.io.File file, String text) {
        try (FileWriter filewriter = new FileWriter(file, true)) {
            filewriter.append(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

