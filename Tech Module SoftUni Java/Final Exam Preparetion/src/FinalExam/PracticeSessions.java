package FinalExam;

import java.util.*;

public class PracticeSessions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = "";
        Map<String, List<String>> roads = new LinkedHashMap<>();

        while (!"END".equals(input = scanner.nextLine())) {
            String[] data = input.split("->");

            String command = data[0];

            if (command.equals("Add")) {
                String road = data[1];
                String racer = data[2];
                if (!roads.containsKey(road)) {
                    roads.put(road, new ArrayList<>());
                }
                roads.get(road).add(racer);
            }
            if (command.equals("Close")) {
                String road = data[1];
                roads.remove(road);
            }

            if (command.equals("Move")) {
                String currentRoad = data[1];
                String racer = data[2];
                String nextRoad = data[3];
                if (roads.get(currentRoad).contains(racer)) {
                    roads.get(nextRoad).add(racer);
                    roads.get(currentRoad).remove(racer);
                }
            }
        }

        System.out.println("Practice sessions:");
        roads.entrySet().stream()
                .sorted((r1, r2) -> {
                    int sort = Integer.compare(r2.getValue().size(), r1.getValue().size());

                    if (sort == 0) {
                        sort = r1.getKey().compareTo(r2.getKey());
                    }
                    return sort;
                }

        ).forEach(kvp -> {
            System.out.println(kvp.getKey());
            kvp.getValue().forEach(r -> System.out.println("++"+ r));
        });



    }
}
