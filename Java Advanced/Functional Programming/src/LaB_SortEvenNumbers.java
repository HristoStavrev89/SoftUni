import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LaB_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] numbersString = scanner.nextLine().split(",\\s+");



        List<String> numbers = Arrays.stream(numbersString)
                .map(Integer::parseInt)
                .filter(x -> x % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.toList());

        String evenNumbers = String.join(", ", numbers);
        System.out.println(evenNumbers);

        List<Integer> intNumbers = numbers.stream()
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());

        List<Integer> sortedInts = intNumbers.stream()
                .sorted((s1, s2) -> Integer.compare(s1, s2))
                .collect(Collectors.toList());

        List<String> collectStringNums = sortedInts.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        String evenNums = String.join(", ",collectStringNums);


        System.out.println(evenNums);

    }
}
