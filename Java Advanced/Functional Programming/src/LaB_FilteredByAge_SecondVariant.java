import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class LaB_FilteredByAge_SecondVariant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);




        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> persons = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(",\\s+");

            String name = data[0];
            int age = Integer.parseInt(data[1]);

            persons.putIfAbsent(name, age);


        }

        String comparison = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String printType = scanner.nextLine();

    }
}
