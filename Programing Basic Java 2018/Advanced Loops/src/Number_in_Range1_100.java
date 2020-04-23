import java.util.Scanner;

public class Number_in_Range1_100 {
    public static void main(String[] args) {
        Scanner  scanner = new Scanner(System.in);
        System.out.println("Enter a number in range [1...100]:");
        int n = Integer.parseInt(scanner.nextLine());

        while (n > 100 || n < 1) {
            System.out.printf("Invalid number!%nEnter a number in the range [1...100]:");
            n = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("The number is: " + n);




    }
}
