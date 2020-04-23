package GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);




        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());

            BoxInt<Integer> boxInt = new BoxInt<>(num);

            System.out.println(boxInt.toString());


        }

    }
}
