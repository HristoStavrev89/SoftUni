import java.util.Scanner;

public class Annual_Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ages = Integer.parseInt(scanner.nextLine());

        String specialisation = scanner.nextLine();

        double money = 0;


        switch (specialisation) {
            case "C# Developer":
                money = 12 * 5400;
                break;
            case "Java Developer":
                money = 12 * 5700;
                break;
            case "Front-End Web Developer":
                money = 12 * 4100;
                break;
            case "UX / UI Designer":
                money = 12 * 3100;
                break;
            case "Game Designer":
                money = 12 * 3600;
                break;
        }

    if (ages < 6) {
            money = money * 0.658 - money;
    }

        System.out.printf("Total earned money: %.2f BGN",Math.abs(money));

    }


}
