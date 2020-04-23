import java.util.Scanner;

public class Illidan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int personPower = Integer.parseInt(scanner.nextLine());
        int blood = Integer.parseInt(scanner.nextLine());


        int totalPower = num * personPower;
        int illidan = totalPower - blood;
        int need = blood - totalPower;

        if (totalPower > blood) {
            System.out.printf("Illidan has been slain! You defeated him with %d points.",illidan);
        } else {
            System.out.printf("You are not prepared! You need %d more points.",need);
        }


    }
}
