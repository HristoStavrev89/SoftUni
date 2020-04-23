import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exercises_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] compounds = scanner.nextLine().split("\\s+");

            for (int j = 0; j < compounds.length; j++) {
                    elements.add(compounds[j]);

            }


        }

        elements.forEach(element -> {
            System.out.print(element + " ");
        });
    }
}
