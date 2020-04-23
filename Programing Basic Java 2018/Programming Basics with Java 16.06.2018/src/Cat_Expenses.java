import java.util.Scanner;

public class Cat_Expenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double bed = Double.parseDouble(scanner.nextLine());
        double toilet = Double.parseDouble(scanner.nextLine());

        double food = toilet + (toilet * 0.25);// 20
        double play = food - (food * 0.50); // 10
        double veterinar = play + (play * 0.10);
        double month = toilet + food + play + veterinar;
        double nepredvideni = month * 0.05;
        double year = bed + 12 * month + 12 * nepredvideni;


        System.out.printf("%.2f lv.",year);


    }
}
