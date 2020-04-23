import java.util.Scanner;

public class Airplane {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int h = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int t = Integer.parseInt(scanner.nextLine());

        int min = m + t;

        int hoursToAdd = min / 60;
        int minToAdd = min % 60;

        int totalHours = h + hoursToAdd;

        if (totalHours == 24) {
            totalHours = 0;
        }
        if (totalHours > 24) {
            totalHours = totalHours - 24;
        }
        System.out.printf("%dh %dm",totalHours,minToAdd);

    }
}
