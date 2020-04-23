import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class E_SumLines {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


            try {
                String line = reader.readLine();

                while (!line.equals("")) {
                    int asciSum = 0;

                    for (char symbol : line.toCharArray()) {
                        asciSum += symbol;
                    }
                    System.out.println(asciSum);
                    line = reader.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}
