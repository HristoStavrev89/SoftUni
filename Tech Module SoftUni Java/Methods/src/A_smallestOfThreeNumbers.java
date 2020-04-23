import java.util.Scanner;

public class A_smallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        theSmallOne(a,b,c);

    }

    private static void theSmallOne(int a, int b, int c) {
        int theSmalest;
        if (a < b && a < c) {
            theSmalest = a;
        } else if (b < a && b < c) {
            theSmalest = b;
        } else {
            theSmalest = c;
        }
        System.out.println(theSmalest);
    }
}
