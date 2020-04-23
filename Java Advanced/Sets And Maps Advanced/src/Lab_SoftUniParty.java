import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> regular = new ArrayList<>();
        List<String> vip = new ArrayList<>();
        String input = "";

        while (!"PARTY".equals(input = scanner.nextLine())) {
            char type = input.charAt(0);
            if (Character.isAlphabetic(type)) {
                regular.add(input);
            } else if (Character.isDigit(type)) {
                vip.add(input);
            }
        }
        while (!"END".equals(input = scanner.nextLine())) {

            char type = input.charAt(0);
            if (Character.isAlphabetic(type)) {
                regular.remove(input);
            } else if (Character.isDigit(type)) {
                vip.remove(input);
            }
        }
        System.out.println(regular.size() + vip.size());
        if (!vip.isEmpty()) {
            vip.stream().sorted(String::compareTo)
                    .forEach(s -> {
                        System.out.println(s);
                    });
        }
        if (!regular.isEmpty()) {
            regular.stream().sorted(String::compareTo)
                    .forEach(s -> {
                        System.out.println(s);
                    });
        }
    }
}
