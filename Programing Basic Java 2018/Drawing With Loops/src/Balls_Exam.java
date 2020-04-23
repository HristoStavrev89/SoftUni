import java.util.Scanner;

public class Balls_Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int balls = Integer.parseInt(scanner.nextLine());
        int points = 0;
        int redBalls = 0;
        int orangeBalls = 0;
        int yellowBalls = 0;
        int whiteBalls = 0;
        int otherBalls = 0;
        int devidesBlack = 0;

        for (int i = 0; i < balls; i++) {
            String color = scanner.nextLine();

            switch (color) {
                case "red":
                    points += 5;
                    redBalls += 1;
                    break;
                case "orange":
                    points += 10;
                    orangeBalls += 1;
                    break;
                case "yellow":
                    points += 15;
                    yellowBalls += 1;
                    break;
                case "white":
                    points += 20;
                    whiteBalls += 1;
                    break;
                case "black":
                    points = points / 2;
                    devidesBlack += 1;
                    break;
                default:
                    otherBalls += 1;
                    break;
            }

        }
        System.out.println("Total points: " + points);
        System.out.println("Points from red balls: " + redBalls);
        System.out.println("Points from orange balls: " + orangeBalls);
        System.out.println("Points from yellow balls: " + yellowBalls);
        System.out.println("Points from white balls: " + whiteBalls);
        System.out.println("Other colors picked: " + otherBalls);
        System.out.println("Divides from black balls: " + devidesBlack);
    }
}
