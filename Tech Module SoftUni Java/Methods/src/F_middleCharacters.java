import java.util.Scanner;

public class F_middleCharacters {
//    static String printMiddleCharacters (String a) {
//        String middle;
//
//
//
//
//        return middle;
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();

        String[] arrayText = a.split("");

        for (int i = 0; i < arrayText.length; i++) {
            if (i == arrayText.length / 2) {
                System.out.println(arrayText[i - 1] + arrayText[i]);
            } else {

            }
        }




    }
}
