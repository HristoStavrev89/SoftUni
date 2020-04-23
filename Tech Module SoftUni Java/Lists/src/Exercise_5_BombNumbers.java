import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise_5_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine()
        .split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String[] bomb = scanner.nextLine().split(" ");



        int sum = 0;

        int bombNumber = Integer.parseInt(bomb[0]);
        int bombPower = Integer.parseInt(bomb[1]);


        while (numbers.contains(bombNumber)) {
            int index = numbers.indexOf(bombNumber);

            int left = Math.max(0,index - bombPower);
            int right = Math.min(index + bombPower,numbers.size() - 1);

            for (int i = right; i >= left ; i--) {
                numbers.remove(i);
            }


        }
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        System.out.println(sum);

    }
}
