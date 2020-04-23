import java.util.Scanner;

public class O_3_Equal_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2= Integer.parseInt(scanner.nextLine());

        if (num == num1 && num1 == num2) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }


    }
}
