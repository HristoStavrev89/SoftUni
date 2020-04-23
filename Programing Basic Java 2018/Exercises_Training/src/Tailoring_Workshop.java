import java.util.Scanner;

public class Tailoring_Workshop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tables = Double.parseDouble(scanner.nextLine());
        double lenght = Double.parseDouble(scanner.nextLine());
        double widht = Double.parseDouble(scanner.nextLine());

        double rectangleSizes = tables * (lenght + 2 * 0.30) * (widht + 2 * 0.30);
        double squareSize = tables * (lenght / 2)* (lenght / 2);

        double USD = rectangleSizes * 7 + squareSize * 9;
        double BGN = USD * 1.85;

        System.out.printf("%.2f" + " USD",USD);
        System.out.println();
        System.out.printf("%.2f" + " BGN" ,BGN);









    }
}
