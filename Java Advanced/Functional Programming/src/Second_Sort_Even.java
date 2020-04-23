import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Second_Sort_Even {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        int[] nums = Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        List<Integer> numsLIst = Arrays.stream(reader.readLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        numsLIst.removeIf(n -> n % 2 != 0);

        numsLIst.sort((a, b) -> b - a);



        Predicate<Integer> pred = x -> x  % 2 == 0;

        Arrays.stream(nums)
                .filter(f -> pred.test(f))
                .forEach(e -> System.out.print(String.format("%d ", e)));

        Arrays.sort(nums);
        System.out.println();

        Arrays.stream(nums)
                .filter(f -> pred.test(f))
                .forEach(e -> System.out.printf("%d ", e));









    }
}
