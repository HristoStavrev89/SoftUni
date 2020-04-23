package FinalExam;

import java.util.*;

public class OnTheWayToAnnapurna {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, List<String>> store = new LinkedHashMap<>();

        String input = "";

        while (!"END".equals(input = scanner.nextLine())) {
            String[] data = input.split("->|,");

            System.out.println();
            if (data[0].equals("Add")) {
                String[] items = input.substring(input.lastIndexOf(">") + 1).split(",");

                for (int i = 0; i < items.length; i++) {
                    if (!store.containsKey(data[1])) {
                        store.put(data[1], new ArrayList<>());
                    }
                    store.get(data[1]).add(items[i]);
                }
            }
            if (data[0].equals("Remove")) {
                    store.remove(data[1]);

            }

        }


        System.out.println("Stores list:");
        store.entrySet().stream()
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue().size(), e1.getValue().size());

                    if (sort == 0) {
                        sort = e2.getKey().compareTo(e1.getKey());
                    }
                    return sort;
                }).forEach(kvp -> {
            System.out.println(String.format("%s", kvp.getKey()));

            kvp.getValue().forEach(s -> {
                System.out.println(String.format("<<%s>>",s));
            });
        });









    }
}
