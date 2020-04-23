import java.util.Scanner;

public class Tree {
    public static void main(String[] agrs) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String firstRow = repeatStr(" ", n + 1)
                + "|"
                + repeatStr(" ", n + 1);
        System.out.println(firstRow);

        for (int i = 0; i < n ; i++) {
            String middle = repeatStr(" ", n - 1 - i)
                    + repeatStr("*", 1 + i)
                    + " | "
                    + repeatStr("*", 1 + i)
                    + repeatStr(" ", n - 1 - i);
            System.out.println(middle);
        }
    }
    static String repeatStr(String text, int count) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            result.append(text);

        }
        return result.toString();
    }
}