package Figures;

import java.util.Scanner;

public class Sunglasses {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String firstRow = repeatString("*", 2 * n)
                + repeatString(" ", n)
                + repeatString("*", 2 * n);
        System.out.println(firstRow);

        for (int row = 0; row < n - 2 ; row++) {
            String middlePart = "*"
                    +  repeatString("/", (2 * n) - 2)
                    + "*"
                    + repeatString(" ", n)
                    + "*"
                    + repeatString("/", (2 * n) - 2)
                    + "*";

            if(row == (n-1) / 2 - 1 ){
                middlePart = "*"
                        +  repeatString("/", (2 * n) - 2)
                        + "*"
                        + repeatString("|", n)
                        + "*"
                        + repeatString("/", (2 * n) - 2)
                        + "*";
            }
            System.out.println(middlePart);
        }

        String lastRow = repeatString("*", 2 * n)
                + repeatString(" ", n)
                + repeatString("*", 2 * n);

        System.out.println(lastRow);
    }
    public static String repeatString(String text, int times) {
        StringBuilder result = new StringBuilder();

        while(times > 0) {
            result.append(text);

            times--;
        }

        return result.toString();
    }
}