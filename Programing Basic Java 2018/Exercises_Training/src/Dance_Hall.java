import java.util.Scanner;

public class Dance_Hall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double L = Double.parseDouble(scanner.nextLine());
        double W = Double.parseDouble(scanner.nextLine());
        double A = Double.parseDouble(scanner.nextLine());

        double roomsize = (L * 100) * (W * 100);
        double wardrobe = A * A;
        double bench = roomsize / 10;
        double freeroom = roomsize - wardrobe - bench;
        double dancers = freeroom / (40 + 70);

        System.out.print(Math.floor(dancers));

    }
}
