import java.util.Scanner;

public class BeerBottle {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int n = Integer.parseInt(scanner.nextLine());

        String firstRow = repeatStr(" ", n / 2)
                + repeatStr("*", n + 1);
        System.out.println(firstRow);

        for (int i = 0; i < n / 2; i++) {
            String middlePart = repeatStr(" ",n / 2)
                    + "*"
                    + repeatStr(" ",n - 1)
                    + "*";
            System.out.println(middlePart);
        }

        for (int i = 0; i < n /2; i++) {
            String middlePart2 = repeatStr(" ",n / 2 - i)
                    + "*"
                    + repeatStr(" ", n - 1 + 2 * i)
                    + "*"
                    + repeatStr(" ",n / 2 - i);
            System.out.println(middlePart2);
        }

        for (int i = 0; i < n; i++) {
            String bottom1 = "*"
                    + repeatStr(".", 2 * n - 2)
                    + "*";
            System.out.println(bottom1);
        }

        for (int i = 0; i < n; i++) {
            String bottom2 = "*"
                    + repeatStr("@", 2 * n - 2)
                    + "*";
            System.out.println(bottom2);
        }

        for (int i = 0; i < n *2; i++) {
            String end = "*";
            System.out.print(end);
        }













    }
    static String repeatStr (String text, int count) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count ; i++) {
            result.append(text);
        }
        return result.toString();
    }
}
