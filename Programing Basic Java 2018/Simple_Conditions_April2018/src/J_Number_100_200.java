import java.util.Scanner;

public class J_Number_100_200 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());


        if (num <= 99) {
            System.out.println("Less than 100");
        } else if (num <= 200) {
            System.out.println("Between 100 and 200");
        } else if (num >= 201) {
            System.out.println("Greater than 200");
        }
    }
}

