import java.util.*;

public class ClubPartyyyy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int hallMax = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> input = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(input::push);

        List <String> letters = new ArrayList<>();
        List <Integer> nums = new ArrayList<>();

        Map<String, List<Integer>> halls = new LinkedHashMap<>();


        while (input.isEmpty()) {
            String crruent = input.pop();

            if (halls.isEmpty() && Character.isDigit(crruent.charAt(0))) {
                continue;
            }













        }



    }
}
