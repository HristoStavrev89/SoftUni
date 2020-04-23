import java.util.Scanner;

public class exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int partySize = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int coins = 0;


        for (int i = 1; i <= days; i++) {
            if (i % 10 == 0) {
                partySize = partySize - 2;
            }
            if (i % 15 == 0) {
                partySize = partySize + 5;
            }
            coins += (50 - 2 * partySize);

            if (i % 3 == 0) { // every third day
                coins = coins - (partySize * 3); // spending 3 coins per party companion
            }
            if (i % 5 == 0) { // every 5 day
                coins = coins + (partySize * 20);
                if (i % 3 == 0) {
                    coins = coins - (partySize * 2);
                }
            }




        }



        coins = coins / partySize;

        System.out.println(partySize + " companions received " + coins + " coins each.");


    }
}
