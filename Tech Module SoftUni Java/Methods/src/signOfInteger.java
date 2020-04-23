import java.util.Scanner;

public class signOfInteger {
    public static void positiveOrNotInteger (int number) {
        if (number > 0) {
            System.out.printf("The number %d is positive.",number);
        } else if (number < 0) {
            System.out.printf("The number %d is negative.", number);
        } else {
            System.out.printf("The number %d is zero.", number);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        positiveOrNotInteger(number);

    }


}
