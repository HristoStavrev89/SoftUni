import java.util.*;

public class Exercises_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Map<Character, Integer> symbols = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
                symbols.putIfAbsent(current, 0);
                symbols.put(current, symbols.get(current) + 1);
        }
        symbols.forEach((K, V) -> {
            System.out.println(String.format("%c: %d time/s",K,V));
        });
    }
}
