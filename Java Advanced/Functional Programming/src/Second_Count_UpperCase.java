import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class Second_Count_UpperCase {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));




        String[] text = reader.readLine().split("\\s+");

        int counter = 0;


        Predicate<String> checkUpperCase = word -> Character.isUpperCase(word.charAt(0));



        Arrays.stream(text)
                .filter(word -> checkUpperCase.test(word))
                .forEach(e -> System.out.println(e));







    }
}
