import java.util.Scanner;

public class Slot_Machine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // char symbol = 67;
       // System.out.println(symbol);
       // int a = (char)5;
       // System.out.println(a);


        char n = scanner.nextLine().charAt(0);
        int n1 = Integer.parseInt(scanner.nextLine());
        char m = scanner.nextLine().charAt(0);
        int m1 = Integer.parseInt(scanner.nextLine());
        char k = scanner.nextLine().charAt(0);
        int k1 = Integer.parseInt(scanner.nextLine());

        int symbolN = (char)n + n1;
        int symbolM = (char)m + m1;
        int symbolK = (char)k + k1;

        char symbolNN = (char) symbolN;
        char symbolMM = (char) symbolM;
        char symbolKK = (char) symbolK;

       char one = symbolNN;
       char two = symbolMM;
       char three = symbolKK;

        if (one == 55 && two == 55 && three == 55) {
            System.out.print(one);
            System.out.print(two);
            System.out.print(three);
            System.out.println();
            System.out.println("*** JACKPOT ***");
            }
            else if (one == 64 && two == 64 && three == 64) {
            System.out.print(one);
            System.out.print(two);
            System.out.print(three);
            System.out.println();
            System.out.println("!!! YOU LOSE EVERYTHING !!!");
        } else {
            System.out.print(one);
            System.out.print(two);
            System.out.print(three);
        }















    }
}
