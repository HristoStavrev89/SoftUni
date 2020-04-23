package borderControl;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

        String input = "";


        while (!"End".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");

            for (int i = 1; i <= data.length; i++) {
                if (i == data.length) {
                    checkId(data[i]);
                }
            }




        }


    }
    public static void checkId(String id) {
        if (id.endsWith("122")) {
            System.out.println(id);
        }
    }
}
