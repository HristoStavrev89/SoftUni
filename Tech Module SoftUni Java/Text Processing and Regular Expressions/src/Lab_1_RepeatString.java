import java.util.Scanner;

public class Lab_1_RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


//        String[] words = scanner.nextLine().split("\\s+");
//        String result = "";
//
//        for (int i = 0; i < words.length; i++) {
//            int length = words[i].length();
//            for (int j = 0; j < length; j++) {
//                result += words[i];
//            }
//        }
//        System.out.println(result);


                String[] text = scanner.nextLine().split("\\s+");


        StringBuilder result = new StringBuilder();

        for (String word : text) {
            int count = word.length();
            for (int i = 0; i < count; i++) {
                result.append(word);
            }

        }
        System.out.println(result);

    }
}
