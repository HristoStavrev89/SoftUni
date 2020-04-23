import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab_SortEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        numbers.removeIf(n -> n % 2 != 0);

        List<String> stringNumbers = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", stringNumbers));

        List<String> sorted = numbers.stream()
                .sorted(Integer::compareTo)
                .map(Object::toString)
                .collect(Collectors.toList());

        System.out.println(String.join(", ",sorted));


    }
}
