import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class LaB_AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double[] prices = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        UnaryOperator<Double> addVat = value -> value * 1.2;

        System.out.println("Prices with VAT:");

        Arrays
                .stream(prices)
                .forEach(price -> System.out.println(String.format("%.2f",addVat.apply(price))));

    }
}
