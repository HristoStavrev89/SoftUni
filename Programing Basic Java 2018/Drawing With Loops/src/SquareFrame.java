import java.util.Scanner;

public class SquareFrame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String firstAndLastRow = "+ " + repeatStr("- ", n - 2) + "+";

        System.out.println(firstAndLastRow);

        for (int i = 0; i < n - 2; i++) {
            String middlePart = "| " + repeatStr("- ", n -2) + "|";
            System.out.println(middlePart);
        }

        System.out.println(firstAndLastRow);

    }
    static String repeatStr (String text, int count) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count ; i++) {
            result.append(text);
        }
        return result.toString();
    }
}
