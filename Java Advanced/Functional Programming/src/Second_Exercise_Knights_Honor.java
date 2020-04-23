import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class Second_Exercise_Knights_Honor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Consumer<String> appendSir = name -> System.out.println("Sir " + name);

        String[] names = reader.readLine().split("\\s+");

        Arrays.stream(names)
                .forEach(name -> appendSir.accept(name));






    }
}
