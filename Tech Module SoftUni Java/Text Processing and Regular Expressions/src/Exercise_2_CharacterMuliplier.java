import java.util.Scanner;

public class Exercise_2_CharacterMuliplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        String first = input.substring(0, input.indexOf(' '));
        String second = input.substring(input.lastIndexOf(' ') + 1);

        System.out.println(characterMultiplier(first, second));

    }

    private static int characterMultiplier(String first, String second) {
        int minLegth = Math.min(first.length(), second.length());

        int sum = 0;
        for (int i = 0; i < minLegth; i++) {
            sum += first.charAt(i) * second.charAt(i);
        }

        String maxLength = first.length() < second.length()
                ? second : first;


        for (int i = minLegth; i < maxLength.length(); i++) {
            sum += maxLength.charAt(i);
        }
        return sum;


    }
}
