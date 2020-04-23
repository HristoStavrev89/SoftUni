import java.util.Scanner;

public class G_Sum_Seconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ico = Integer.parseInt(scanner.nextLine());
        int niki = Integer.parseInt(scanner.nextLine());
        int mocho = Integer.parseInt(scanner.nextLine());
        int result = ico+niki+mocho;

        int minutes = result / 60;
        int seconds = result % 60;

        if(seconds < 10){
            System.out.printf("%d:0%d",minutes,seconds);
        }else {
            System.out.printf("%d:%d",minutes,seconds);
        }
    }
}
