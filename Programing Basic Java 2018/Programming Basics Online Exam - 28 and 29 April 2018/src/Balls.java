import java.util.Scanner;

public class Balls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int red = 0;
        int orange = 0;
        int yellow = 0;
        int white = 0;
        int black = 0;
        int other = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {
            String color = scanner.nextLine();
            if (color.equals("red")) {
                red ++;
                total += 5;
            } else if (color.equals("orange")) {
                orange ++;
                total += 10;
            } else if (color.equals("yellow")) {
                yellow ++;
                total += 15;
            } else if (color.equals("white")) {
                white ++;
                total += 20;
            } else if (color.equals("black")) {
                black ++;
                total /= 2;
            } else {
                other ++;
            }
            }

        System.out.println("Total points: " + total);
        System.out.println("Points from red balls: " + red);
        System.out.println("Points from orange balls: " + orange);
        System.out.println("Points from yellow balls: " + yellow);
        System.out.println("Points from white balls: " + white);
        System.out.println("Other colors picked: " + other);
        System.out.println("Divides from black balls: " + black);



    }

}
