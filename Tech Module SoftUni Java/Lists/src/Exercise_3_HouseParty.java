import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise_3_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        List<String> names = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            String[] tokens = input.split(" ");


            if (tokens[2].equals("going!") && !names.contains(tokens[0])) {
                names.add(tokens[0]);
            } else if (tokens[2].equals("going!") && names.contains(tokens[0])) {
                System.out.println(tokens[0] + " is already in the list!");
            } else if (tokens[2].equals("not") && !names.contains(tokens[0])) {
                System.out.println(tokens[0] + " is not in the list!");
            } else if (tokens[2].equals("not") && names.contains(tokens[0])) {
                names.remove(tokens[0]);
            }


        }

        for (String name : names) {
            System.out.println(name);
        }




    }
}
