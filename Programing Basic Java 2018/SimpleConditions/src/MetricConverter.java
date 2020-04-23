import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double value = Double.parseDouble(scanner.nextLine());
        String inputunit = scanner.nextLine();
        String outputunit = scanner.nextLine();


        // double mm = meter * 1000;
        // double km = meter / 1000;
        // double cm = meter * 100;
        // double ft = meter * 3.2808399;
        // double yd = meter * 1.0936133;
        // double mi = meter * 0.000621371192;
        // double in = meter * 39.3700787;


        //                             ДА СЕ ДОВЪРШИ/ОПРАВИ ПРОГРАМАТА!!!!!!

        // double value = 1;

        if (inputunit.equals("mm")) {
            value = value * 1000;
        } else if (inputunit.equals("km")) {
            value = value / 1000;
        } else if (inputunit.equals("cm")) {
            value = value * 100;
        } else if (inputunit.equals("ft")) {
            value = value * 3.2808399;
        } else if (inputunit.equals("yd")) {
            value = value * 1.0936133;
        } else if (inputunit.equals("mi")) {
            value = value * 0.000621371192;
        } else if (inputunit.equals("in")) {
            value = value * 39.3700787;
        }

        double coef = 0;
        if (outputunit.equals("mm")) {
            value = value * 1000;
        } else if (outputunit.equals("km")) {
            value = value / 1000;
        } else if (outputunit.equals("cm")) {
            value = value * 100;
        } else if (outputunit.equals("ft")) {
            value = value * 3.2808399;
        } else if (outputunit.equals("yd")) {
            value = value * 1.0936133;
        } else if (outputunit.equals("mi")) {
            value = value * 0.000621371192;
        } else if (outputunit.equals("in")) {
            value = value * 39.3700787;
        }


        System.out.println(value);


    }
}
