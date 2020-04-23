import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercises_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Set<String> first = new LinkedHashSet<>();
        Set<String> second = new LinkedHashSet<>();

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String number = scanner.nextLine();
            first.add(number);
        }

        for (int i = 0; i < m; i++) {
            String number = scanner.nextLine();
            second.add(number);
        }

        // Print non-repeating elements from the both sets
        first.forEach(element -> {
            second.forEach(secondElement -> {
                if (element.equals(secondElement)) {
                    System.out.print(secondElement + " ");
                }
            });
        });

        // Alternative, print non-repeating elements
//        first.retainAll(second);
//        first.forEach(e -> System.out.print(e + " "));


    }
}
