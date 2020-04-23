import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class Second_ADD_VAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



        double[] prices = Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        System.out.println("Prices with VAT:");

        UnaryOperator<Double> withVat = num -> num * 1.2;

        Arrays.stream(prices)
                .forEach(num ->
                    System.out.println(String.format("%.2f", withVat.apply(num)))
                );



    }
}
