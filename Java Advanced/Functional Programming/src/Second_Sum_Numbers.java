import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Second_Sum_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));




        int[] numbers = Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        List<Integer> numList = Arrays.stream(reader.readLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        System.out.println("array sum:");
        int sum = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        System.out.println(numbers.length);

        System.out.println();

        System.out.println("list variant: ");
        int result = numList.stream().reduce(0, (a, b) -> a + b);
        System.out.println(result);
        System.out.println(numList.size());



//        System.out.println(Arrays.stream(numbers)
//                .sum());




    }
}
