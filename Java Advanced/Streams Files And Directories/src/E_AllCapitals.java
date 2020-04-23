import java.io.*;
import java.util.Scanner;

public class E_AllCapitals {
    public static void main(String[] args)  {



        String userDir = System.getProperty("user.dir");
        String pathIn = userDir + "/res/input.txt";
        String pathOut = userDir + "/res/output.txt";


        System.out.println();

        try (BufferedReader  reader = new BufferedReader(new FileReader(pathIn));
             PrintWriter writer = new PrintWriter(new FileWriter(pathOut))) {

            String line = reader.readLine();

            while (line != null) {

                String current = line.toUpperCase();

                writer.write(current);
                writer.append(System.lineSeparator());

                line = reader.readLine();
            }


        }  catch (IOException e) {
            e.printStackTrace();
        }




    }
}
