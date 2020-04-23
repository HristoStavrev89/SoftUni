import java.util.Arrays;
        import java.util.List;
        import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LaB_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // First
//        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
//                .map(Integer::parseInt).collect(Collectors.toList());
//        System.out.println("Count = " + numbers.size());
//        System.out.println("Sum = " + numbers.stream().mapToInt(number -> number).sum());



        //Second variant
        Function<String, Integer> parse = s -> Integer.parseInt(s);

        String[] numbers = scanner.nextLine().split(",\\s+");

        List<Integer> nums = Arrays.stream(numbers)
                .map(parse).collect(Collectors.toList());

        System.out.println("Count = " + nums.size());

        int sum = nums.stream().reduce(0, (a, b) -> a + b);





        System.out.println("Sum = " + sum);



    }
}
