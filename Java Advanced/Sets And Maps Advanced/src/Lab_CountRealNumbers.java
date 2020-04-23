import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Lab_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        LinkedHashMap<Double, Integer> numbers = new LinkedHashMap<>();

        String[] input = scanner.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i++) {
            double current = Double.parseDouble(input[i]);

            if (!numbers.containsKey(current)) {
                numbers.put(current, 1);
            } else {
                numbers.put(current, numbers.get(current) + 1);
            }

        }

        numbers
                .entrySet()
                .stream()
                .forEach(e -> {
                    System.out.println(String.format("%.1f -> %d", e.getKey(), e.getValue()));
                });


    }
}
