import java.util.Scanner;

public class Time_15_Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int hh = Integer.parseInt(scanner.nextLine());
        int mm = Integer.parseInt(scanner.nextLine());

        int totalTime = hh * 60 + mm + 15;
        hh = totalTime / 60;
        mm = totalTime % 60;

        if (hh == 24) {
            hh = 0;
        }
        System.out.printf ("%d:%02d",hh,mm);

    }
}
