import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String year = scanner.nextLine();
        int p = Integer.parseInt(scanner.nextLine());
        int h = Integer.parseInt(scanner.nextLine());

        double weekendsInSofia = 48 - h;
        double gamesSofia = weekendsInSofia * 3 / 4;
        double gamesRuse = h;
    }
}
