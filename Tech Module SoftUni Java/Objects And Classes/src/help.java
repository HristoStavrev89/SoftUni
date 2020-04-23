
import java.util.*;
import java.util.stream.Collectors;

public class help {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> result = new ArrayList<>();

        String command = scanner.nextLine();

        while (!(command.equals("END"))) {
            String[] commandArr = command.split(" ");

            switch (commandArr[0]) {
                case "Insert":
                    result = insert(numbers, Integer.parseInt(commandArr[1]), commandArr[2]);
                    break;
                case "Switch":
                    result = switchNumbers(numbers, commandArr[1], commandArr[2]);
                    break;
                case "Hide":
                    result = hide(numbers, commandArr[1]);
                    break;
                case "Reverse":
                    result = reverse(numbers);
                    break;
                case "Change":
                    result = change(numbers, commandArr[1], commandArr[2]);
                    break;

            }

            command = scanner.nextLine();
        }
        System.out.println(printList(result));
    }

    private static List<String> change(List<String> numbers, String oldNum, String newNum) {
        if (numbers.contains(oldNum)) {
            int getIndex = numbers.indexOf(oldNum);
            numbers.set(getIndex, newNum);
        }
        return numbers;
    }

    private static List<String> reverse(List<String> numbers) {
        Collections.reverse(numbers);
        return numbers;
    }

    private static List<String> hide(List<String> numbers, String num) {
        numbers.remove(num);
        return numbers;
    }

    private static List<String> switchNumbers(List<String> numbers, String num1, String num2) {
        int indexNum1 = numbers.indexOf(num1);
        int indexNum2 = numbers.indexOf(num2);
        if (indexNum1 != -1 && indexNum2 != -1) {
            String valueNum1 = numbers.get(indexNum1);
            String valueNum2 = numbers.get(indexNum2);
            numbers.remove(num1);
            numbers.remove(num2);
            numbers.add(indexNum1, valueNum2);
            numbers.add(indexNum2, valueNum1);
        }
        return numbers;
    }

    private static List<String> insert(List<String> numbers, int position, String numberStr) {
        if (position >= 0 && position <= numbers.size()) {
            numbers.add(position + 1, numberStr);
        }
        return numbers;
    }

    private static String printList(List<String> result) {
        return result.toString().replaceAll("[\\[,\\]]", "");
    }
}