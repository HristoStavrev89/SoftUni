import java.util.Scanner;

public class Lab_3_ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!"end".equals(input = scanner.nextLine())) {
            String current = input;

            String reverse =  new StringBuilder(current).reverse().toString();

            System.out.println(current + " = " + reverse);
        }

//        while (!"end".equals(input = scanner.nextLine())) {
//            String reversed = "";
//
//            for (int i = input.length() - 1; i >= 0; i--) {
//                reversed += input.charAt(i);
//
//
//            }
//            System.out.println(input + " = " + reversed);
//        }
    }
}
