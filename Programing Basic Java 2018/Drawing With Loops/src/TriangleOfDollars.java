import java.util.Scanner;

public class TriangleOfDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println(repeatStr("$",1 + i));
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
