import java.util.Scanner;

public class Rate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double s = Double.parseDouble(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());


        double simple = s;
        double hard = s;
        double result = 0;

        for (int i = 0; i < n; i++) {
            simple = simple + (s * 0.03);
            hard = hard + (hard * 0.027);
            }



        System.out.printf("Simple interest rate: %.2f lv.",simple);
        System.out.println();
        System.out.printf("Complex interest rate: %.2f lv.",hard);
        System.out.println();



            if (simple > hard) {
            result = simple - hard;
                System.out.printf("Choose a simple interest rate. You will win %.2f lv.",result);
            } else {
            result = hard - simple;
                System.out.printf("Choose a complex interest rate. You will win %.2f lv.",result);
            }









    }
}
