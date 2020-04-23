import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String Projection = scanner.nextLine();
        int vertical = Integer.parseInt(scanner.nextLine());
        int horizontal = Integer.parseInt(scanner.nextLine());
        int seats = vertical * horizontal;
        double result = 0;

        switch (Projection) {
            case "Premiere":
            result = seats * 12.00;
                System.out.printf("%.2f leva", result);
                break;
            case "Normal":
            result = seats * 7.50;
                System.out.printf("%.2f leva", result);
                break;
            case "Discount":
                result = seats * 5.00;
                System.out.printf("%.2f leva", result);
                break;
        }


    }
}
