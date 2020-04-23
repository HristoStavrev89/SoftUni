import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class Second_Exercise_Consumer_Print {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        String[] names = reader.readLine().split("\\s+");

        Consumer<String> newLine = x -> System.out.println(x);

        Arrays.stream(names)
                .forEach(name -> newLine.accept(name));



    }
}
