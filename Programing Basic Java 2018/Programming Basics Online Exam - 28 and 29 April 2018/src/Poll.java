import java.util.Scanner;

public class Poll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.parseInt(scanner.nextLine());
        int first = Integer.parseInt(scanner.nextLine());
        double second = first - (first * 0.20);
        double third = second - (second * 0.10);
        double totalVotes = first + second + third;
        int half = total / 2;
        double razlika = totalVotes - half;
        double razlika2 = half - totalVotes;
        if (totalVotes >= half) {
            System.out.printf("First three languages have %.0f votes more", razlika);
        } else if (half >= totalVotes){
            System.out.printf("First three languages have %.0f votes less of half votes", razlika2);
        }

    }
}
