import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String input = "";
        Map<String, Set<String>> forceBook = new LinkedHashMap<>();

        while (!"Lumpawaroo".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+\\|\\s+|\\s+->\\s+");

            if (input.contains("|")) {
                String side = data[0];
                String name = data[1];

                if (!forceBook.containsKey(side)) {
                    forceBook.put(side, new TreeSet<>());
                }
                boolean found = false;
                for (Map.Entry<String, Set<String>> kvp : forceBook.entrySet()) {
                   if (kvp.getValue().contains(name)) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    forceBook.get(side).add(name);
                }

                // another shorter variant
//                if (forceBook.entrySet().stream().noneMatch(e ->
//                        e.getValue().contains(name)))  {
//                    forceBook.get(side).add(name);
//                }



            } else if (input.contains("->")) {
                String side = data[1];
                String name = data[0];

                forceBook.forEach((key, value) -> {
                    value.remove(name);
                });

                if (!forceBook.containsKey(side)) {
                    forceBook.put(side, new TreeSet<>());
                }

                forceBook.get(side).add(name);
                System.out.printf("%s joins the %s side!\n", name, side);

            }

        }

        forceBook.entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 0)
                .sorted((e1, e2) -> {
            int sort = Integer.compare(e2.getValue().size(), e1.getValue().size());

            if (sort == 0) {
                sort = e1.getKey().compareTo(e2.getKey());
            }

            return sort;
        })

                .forEach(kvp -> {
            System.out.println(String.format("Side: %s, Members: %d"
            ,kvp.getKey(), kvp.getValue().size()));

            kvp.getValue().forEach(u -> {
                System.out.println(String.format("! %s", u));
            });

        });


    }
}
