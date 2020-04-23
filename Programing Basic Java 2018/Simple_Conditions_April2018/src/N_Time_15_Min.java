import java.util.Scanner;

public class N_Time_15_Min {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int totalTime = hour * 60 + minutes + 15;
        hour = totalTime / 60;
        minutes = totalTime % 60;

        if (hour == 24) {
            hour = 0;
        }
        System.out.printf ("%d:%02d",hour,minutes);
    }
}
