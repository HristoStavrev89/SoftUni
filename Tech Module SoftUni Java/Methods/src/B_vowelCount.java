import java.util.Scanner;

public class B_vowelCount {
    static int vowelCount(String a) {

        int counter = 0;
        for (int i = 0; i < a.length(); i++) {
            char letter = a.charAt(i);


            if (letter == 'a' || letter == 'A') {
                counter++;
            } else if (letter == 'o'
                    || letter == 'O') {
                counter++;
            } else if (letter == 'u' || letter == 'U') {
                counter++;
            } else if (letter == 'e' || letter == 'E') {
                counter++;
            } else if (letter == 'i' || letter == 'I') {
                counter++;
            }

        }
        return counter;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String a = scanner.nextLine();


        System.out.println(vowelCount(a));


    }
}
