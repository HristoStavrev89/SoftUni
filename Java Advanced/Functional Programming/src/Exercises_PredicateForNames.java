import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Exercises_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        Predicate<String> nameLength = name -> name.length() <= n;
        Consumer<String> printer = System.out::println;
        String[] people = scanner.nextLine().split("\\s+");
        Arrays.stream(people)
                .filter(person -> nameLength.test(person))
                .forEach(printer);

    }
}
