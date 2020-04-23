import java.util.Objects;
import java.util.Scanner;

public class H_Metric_Converter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double num = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        String output = scanner.nextLine();


        if (input.equals("m")) {
            num = num * 1;
        } else if (input.equals("mm")) {
            num = num / 1000;
        } else if (input.equals("cm")) {
            num = num / 100;
        } else if (input.equals("mi")) {
            num = num / 0.000621371192;
        } else if (input.equals("in")) {
            num = num / 39.3700787;
        } else if (input.equals("km")) {
            num = num / 0.001;
        } else if (input.equals("ft")) {
            num = num / 3.2808399;
        } else if (input.equals("yd")) {
            num = num / 1.0936133;
        }

        ////////////

        if (output.equals("m")) {
            num = num * 1;
        } else if (output.equals("mm")) {
            num = num * 1000;
        } else if (output.equals("cm")) {
            num = num * 100;
        } else if (output.equals("mi")) {
            num = num * 0.000621371192;
        } else if (output.equals("in")) {
            num = num * 39.3700787;
        } else if (output.equals("km")) {
            num = num * 0.001;
        } else if (output.equals("ft")) {
            num = num * 3.2808399;
        } else if (output.equals("yd")) {
            num = num * 1.0936133;
        }

        System.out.printf("%.8f %s", num, output);
    }
}
