import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //dni
        double m = Double.parseDouble(scanner.nextLine()); // km za 1 den

        double allKg = m;
        for (int i = 0; i < n; i++) {
            double nextDay = Double.parseDouble(scanner.nextLine());
            m = m + m * (nextDay / 100D);
            allKg += m;
        }
        if (allKg >= 1000) {
            allKg = Math.ceil(allKg - 1000);
            System.out.printf("You've done a great job running %.0f more kilometers!", allKg);
        } else {
            allKg = Math.ceil(1000 - allKg);
            System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers", allKg);
        }
    }
}