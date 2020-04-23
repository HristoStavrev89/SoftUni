import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise_6_CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayer = Arrays.stream(scanner.nextLine()
                .split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondPlayer = Arrays.stream(scanner.nextLine()
                .split(" ")).map(Integer::parseInt).collect(Collectors.toList());


        while (!(firstPlayer.isEmpty() || secondPlayer.isEmpty())) {

            if (firstPlayer.get(0) > secondPlayer.get(0)) {
                firstPlayer.add(firstPlayer.get(0));
                firstPlayer.add(secondPlayer.get(0));
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            } else if (secondPlayer.get(0) > firstPlayer.get(0)) {
                secondPlayer.add(secondPlayer.get(0));
                secondPlayer.add(firstPlayer.get(0));
                secondPlayer.remove(0);
                firstPlayer.remove(0);
            } else  {
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            }
        }
       if (firstPlayer.stream().mapToInt(Integer::intValue).sum() > secondPlayer.stream().mapToInt(Integer::intValue).sum()) {
           System.out.println("First player wins! Sum: " + firstPlayer.stream().mapToInt(Integer::intValue).sum());
       } else {
           System.out.println("Second player wins! Sum: " + secondPlayer.stream().mapToInt(Integer::intValue).sum());
       }
    }
}
