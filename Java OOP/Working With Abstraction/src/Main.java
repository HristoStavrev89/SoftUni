import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);




        if (scanner.nextLine().equals("Card Ranks")) {
            System.out.println("Card Ranks:");
            for (CardSuit suit : CardSuit.values()) {
                System.out.println(String.format("Ordinal value: %d; Name value: %s"
                        , suit.getValue(), suit));
            }
        }









    }
}
