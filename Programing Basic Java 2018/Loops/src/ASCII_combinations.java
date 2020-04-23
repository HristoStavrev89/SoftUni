import java.util.Scanner;

public class ASCII_combinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int sumNumbers = 0;
        int sumLetters = 0;
        int smalLettersSum = 0;
        int others = 0;
        int max = 0;
        String numbers = "";
        String smallLetters = "";
        String Letters = "";
        String theOthers = "";

        for (int i = 0; i < n; i++) {
            char symbol = scanner.nextLine().charAt(0);

            if ((int) symbol >= 48 && (int) symbol <= 57) {
                sumNumbers += (int) symbol;
                numbers += symbol;
            } else if ((int) symbol >= 97 && (int) symbol <= 122) {
                smalLettersSum += (int) symbol;
                smallLetters += symbol;
            } else if ((int) symbol >= 65 && (int) symbol <= 90) {
                sumLetters += (int) symbol;
                Letters += symbol;
            } else if ((int) symbol >= 33 && (int) symbol <= 47) {
                others += (int) symbol;
                theOthers += symbol;
            }
        }
        max = Math.max(Math.max(sumNumbers, smalLettersSum), Math.max(sumLetters, others));
        System.out.printf("Biggest ASCII sum is:%d%n", max);

        if (sumNumbers == max) {
            System.out.println("Combination of characters is:" + numbers);
        } else if (sumLetters == max) {
            System.out.println("Combination of characters is:" + Letters);
        } else if (smalLettersSum == max) {
            System.out.println("Combination of characters is:" + smallLetters);
        } else if (others == max) {
            System.out.println("Combination of characters is:" + theOthers);
        }


    }
}
