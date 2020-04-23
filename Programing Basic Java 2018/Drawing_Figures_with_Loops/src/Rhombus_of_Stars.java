package Figures;

import java.util.Scanner;

public class Rhombus_of_Stars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row < n; row++) {
            System.out.println(stringToRepeat(" ", n - 1 - row) + stringToRepeat("* ", 1 + row));

        }

        for (int row = n - 1; row >= 0 ; row--) {
            System.out.println(stringToRepeat(" ", n  - row) + stringToRepeat("* ", row));
        }

    }
    public static  String stringToRepeat(String text, int times) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < times; i++) {
            result.append(text);
        }

        return result.toString();
    }
}