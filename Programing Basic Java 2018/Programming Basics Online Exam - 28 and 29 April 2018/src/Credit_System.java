import java.util.Scanner;

public class Credit_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int credits = 0;
        double ocenka = 0;


        for (int i = 0; i < n; i++) {
            int courses = Integer.parseInt(scanner.nextLine());
            credits += courses / 10;
            ocenka += courses % 10;
        }

        double srednoCredits = credits / n;
        double srednaOcenka = ocenka / n;


        double resultCredits = 0;

        if (srednaOcenka < 3) {
            resultCredits = (srednoCredits * 0.00) * n;
        } else if (srednaOcenka < 4) {
            resultCredits = (srednoCredits * 0.50) * n;
        } else if (srednaOcenka < 5) {
            resultCredits = (srednoCredits * 0.70) * n;
        } else if (srednaOcenka < 6) {
            resultCredits = (srednoCredits * 0.85) * n;
        } else if (srednaOcenka < 7) {
            resultCredits = (srednoCredits * 1.00) * n;
        }

        System.out.printf("%.2f",resultCredits);
        System.out.println();
        System.out.printf("%.2f",srednaOcenka);







    }
}
