import java.util.Scanner;

public class Lab_5_DigitsAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String text = scanner.nextLine();


        String digits = "";
        String letters = "";
        String others = "";


        for (int i = 0; i < text.length(); i++) {

            char current = text.charAt(i);
           // better way
           if(Character.isDigit(current)) {
               digits += current;
           } else if (Character.isAlphabetic(current)) {
               letters += current;
           } else {
               others += current;
           }

//            if (current > 47 && current < 58) {
//                digits += current;
//            } else if (current > 64 && current < 123) {
//                letters += current;
//            } else {
//                others += current;
//            }


        }

        System.out.println(digits);
        System.out.println(letters);
        System.out.println(others);

    }
}
