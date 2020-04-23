import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());

        int total = 0;

        for (int i = 0; i < days; i++) {
            int liters = Integer.parseInt(scanner.nextLine());

            if (total + liters > 255) {
                System.out.println("Insufficient capacity!");
            } else {
                total += liters;
            }
        }


        System.out.println(total);





    }
}
