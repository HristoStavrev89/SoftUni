import java.util.Scanner;

public class Sum_Seconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ico = Integer.parseInt(scanner.nextLine());
        int niki = Integer.parseInt(scanner.nextLine());
        int mocho = Integer.parseInt(scanner.nextLine());
        int min = 0;
        int sec = 0;
        int result = ico + niki + mocho;

        if (result < 60) {
            sec = result % 60;
        }  else if (result < 120) {
            min+= 1;
            sec = result % 60;
        } else {
            min += 2;
            sec = result % 60;
        }
        if (sec < 10) {
            System.out.printf("%d:0%d",min,sec);
        }
        else {
            System.out.printf("%d:%d",min,sec);

        }



    }
}
