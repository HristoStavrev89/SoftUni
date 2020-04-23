import java.util.*;

public class Exercises_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Set<String>> players = new LinkedHashMap<>();

        Map<String, Integer> results = new LinkedHashMap<>();

        String input = "";

        while (!"JOKER".equals(input = scanner.nextLine())) {
            String[] data = input.split(": ");

            String name = data[0];

            String[] cards = data[1].split(",\\s+");

            players.putIfAbsent(name, new HashSet<>());

            for (int i = 0; i < cards.length; i++) {
                players.get(name).add(cards[i]);

            }
        }

        for (Map.Entry<String, Set<String>> entry : players.entrySet()) {

            int deckPower = calculateDeckPower(entry.getValue());

            System.out.println(String.format("%s: %d", entry.getKey(), deckPower));

        }


    }

    private static int calculateDeckPower(Set<String> deck) {

        int sumPower = 0;

        for (String card : deck) {

            int power = 0;
            if (Character.isDigit(card.charAt(0)) && card.charAt(0) != '1') {
                power += card.charAt(0) - '0';
            } else {
                switch (card.charAt(0)) {
                    case '1':
                        power += 10;
                        break;
                    case 'J':
                        power += 11;
                        break;
                    case 'Q':
                        power += 12;
                        break;
                    case 'K':
                        power += 13;
                        break;
                    case 'A':
                        power += 14;
                        break;
                }
            }

            switch (card.charAt(card.length() - 1)) {
                case 'S':
                    power *= 4;
                    break;
                case 'H':
                    power *= 3;
                    break;
                case 'D':
                    power *= 2;
                    break;

            }


            sumPower += power;

        }

        return sumPower;
    }
}
