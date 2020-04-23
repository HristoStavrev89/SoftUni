import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class C_Extract_Integer {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");



        String pathIn = userDir + "C:\\Users\\Stavrev\\Desktop\\input.txt";
        String pathOut = userDir + "/res/output.txt";

        try (Scanner scanner = new Scanner(new FileReader(pathIn));
             PrintWriter writer = new PrintWriter(pathOut)){

            while (scanner.hasNext()) {
                scanner.next();
                if (scanner.hasNextInt()) {
                   // String asNumText = String.valueOf(scanner.nextInt());
                    writer.println(scanner.nextInt());
                }
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
