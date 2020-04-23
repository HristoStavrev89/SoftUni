import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        for (int row = 1; row <= n; row++) {
            printCurrentRow(n, row);
        }

        for (int row = n - 1; row > 0; row--) {
            printCurrentRow(n, row);
        }


    }

    public static void printCurrentRow(int width, int row) {
        System.out.print(printSpace(" ", width - row));
        System.out.print(printSpace("* ", row));
        System.out.println();
    }

    public static String printSpace(String space, int count) {
        StringBuilder sb = new StringBuilder();

        while (count-- > 0) {
            sb.append(space);
        }
        return sb.toString();
    }


}
