import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            try {
                Integer.parseInt(input);
                System.out.printf("%s is integer type%n",input);
                input = scanner.nextLine();
                continue;
            } catch (Exception ignored) {

            }
            try {
                Double.parseDouble(input);
                System.out.printf("%s is floating point type%n",input);
                input = scanner.nextLine();
                continue;
                } catch (Exception ignored) {

            }
            if (input.toLowerCase().equals("true") || input.toLowerCase().equals("false")) {
                System.out.printf("%s is boolean type%n",input);
                input = scanner.nextLine();
            } else if (input.length() == 1 &&
                    (input.charAt(0) < 48 || input.charAt(0) > 57))  {
                System.out.printf("%s is character type%n",input);
                input = scanner.nextLine();
            } else {
                System.out.printf("%s is string type%n",input);
                input = scanner.nextLine();
            }


        }


    }
}
