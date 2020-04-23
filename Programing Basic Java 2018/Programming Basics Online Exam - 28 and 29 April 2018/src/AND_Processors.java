import java.util.Scanner;

public class AND_Processors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int mustMade = Integer.parseInt(scanner.nextLine());
        int employee = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        double losses = 0;
        double earn = 0;


        double hours = employee * days * 8;
        double madeProcessors = Math.floor(hours / 3);

        if (madeProcessors < mustMade) {
            losses = (mustMade - madeProcessors) * 110.10;
            System.out.printf("Losses: -> %.2f BGN",losses);
        } else {
            earn = (madeProcessors - mustMade) * 110.10;
            System.out.printf("Profit: -> %.2f BGN",earn);
        }



    }
}
