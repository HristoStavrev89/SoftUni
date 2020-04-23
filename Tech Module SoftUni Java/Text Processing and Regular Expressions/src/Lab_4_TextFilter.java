import java.util.Scanner;

public class Lab_4_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        	Text Filter
//        Write a program that takes a text and a string of banned words.
//                All words included in the ban list should be replaced with asterisks "*"
//                , equal to the word's length. The entries in the ban list will be separated by a comma and space ", ".
//        The ban list should be entered on the first input line and the text on the second input line.


                String[] banWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String banWord : banWords) {
            if (text.contains(banWord)) {
                String replace = repeatThis("*", banWord.length());
                text = text.replace(banWord, replace);

            }
        }
        System.out.println(text);










    }
    private static String repeatThis (String text, int count) {
        String result = "";

        for (int i = 0; i < count; i++) {
            result += text;
        }
        return  result;
    }
}
