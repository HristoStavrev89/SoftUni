import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lab_1_RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> words = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        Random random = new Random();

        while (!words.isEmpty()) {
            int randomIndex = random.nextInt(words.size());
            String word = words.get(randomIndex);
            System.out.println(word);
            words.remove(randomIndex);
        }



    }
}
