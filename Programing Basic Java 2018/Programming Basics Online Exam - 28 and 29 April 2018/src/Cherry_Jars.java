import java.util.Scanner;

public class Cherry_Jars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kompot = Integer.parseInt(scanner.nextLine());
        int jam = Integer.parseInt(scanner.nextLine());

        int jarsKompot = kompot + 1;
        int jarsJam = jam + 1;

        double cherryLost = jarsKompot * 0.300;
        double cherryNeededKompot = cherryLost * 0.05;
        double totalCherryKompot = cherryLost + cherryNeededKompot;

        double cherryJamLost = jarsJam * 0.650;
        double cherryNeededJam = cherryJamLost * 0.10;
        double totalCherryJam = cherryJamLost + cherryNeededJam;

        double totalCherry = (totalCherryKompot + totalCherryJam) * 3.20;

        System.out.printf("%.2f", totalCherry);


    }
}
