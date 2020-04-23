import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Exercise_Consumerpoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Consumer<String> printer = print -> System.out.println(print);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(printer);





    }
}
