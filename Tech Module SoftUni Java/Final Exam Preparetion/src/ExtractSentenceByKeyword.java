import java.util.Scanner;

public class ExtractSentenceByKeyword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String keyWord = scanner.nextLine();
        String[] text = scanner.nextLine().split("!\\s+|\\.\\s+|\\s+\\?\\s+");

        for (int i = 0; i < text.length; i++) {
            String sentence = text[i];


            String test1 = " " + keyWord;
            String test2 = keyWord + " ";

            if (sentence.contains(test1) || sentence.contains(test2)) {
                System.out.println(sentence);
            }



        }

    }
}
