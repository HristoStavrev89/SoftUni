import java.util.Scanner;

public class Three_Brothers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double brother1 = Double.parseDouble(scanner.nextLine());
        double brother2 = Double.parseDouble(scanner.nextLine());
        double brother3 = Double.parseDouble(scanner.nextLine());
        double theFather = Double.parseDouble(scanner.nextLine());

        double together = 1 / (1 / brother1 + 1 / brother2 + 1 / brother3);

        double resultRelax = (0.15 * together) + together;

        double timeLeft = theFather - resultRelax;

        System.out.printf("Cleaning time: %.2f%n", resultRelax);

        if (resultRelax > theFather) {
            System.out.printf("No, there isn’t a surprise - shortage of time -> %d hours.",(int) Math.floor(timeLeft)); // CHANGE
        } else {
            System.out.printf("Yes, there is a surprise - time left -> %d hours.", Math.ceil(timeLeft)); // CHANGE
        }

    }
}
// DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG DEBUG