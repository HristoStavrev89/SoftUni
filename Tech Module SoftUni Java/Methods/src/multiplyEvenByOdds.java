import java.util.Scanner;

public class multiplyEvenByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int[] integers = intToArrayInt(num);

        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 2 == 0) {
                evenSum += integers[i];
            } else {
                oddSum += integers[i];
            }
        }
        System.out.println(Math.abs(evenSum * oddSum));
        }

    private static int[] intToArrayInt(int num) {
        String number = String.valueOf(num);

        int[] integers = new int[number.length()];

        for (int i = 0; i < number.length(); i++) {
            integers[i] = Character.digit(number.charAt(i), 10);
        }
        return integers;
    }


}
