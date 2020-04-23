import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_1_CountCharsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String text = String.join("",scanner.nextLine().split("\\s+"));

        System.out.println();


        Map<Character, Integer> countChars = new LinkedHashMap<>();


        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);


            if (!countChars.containsKey(symbol)) {
                countChars.put(symbol, 1);
            } else {
                countChars.put(symbol, countChars.get(symbol) + 1);
            }
        }

//          The first method

//        countChars.entrySet().forEach(e -> {
////            System.out.println(
////                    String.format("%c -> %d",e.getKey(),e.getValue())
////            );
////        });

        System.out.println("With For:");
         for (Map.Entry<Character, Integer> count : countChars.entrySet()) {
             System.out.println(String.format("%c -> %d",count.getKey(),count.getValue()));
         }

        System.out.println("Foreach:");
        countChars.forEach((key, value) -> System.out.println(
                String.format("%c -> %d", key, value)
        ));






    }
}
