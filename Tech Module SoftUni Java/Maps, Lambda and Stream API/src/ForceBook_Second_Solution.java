import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ForceBook_Second_Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Map<String, Set<String>> forceBook = new HashMap<>();

        String input = reader.readLine();

        while (!input.equals("Lumpawaroo")) {

            if (input.contains(" | ")) {
                String[] data = input.split(" \\| ");
                String side = data[0];
                String user = data[1];

                forceBook.putIfAbsent(side, new TreeSet<>());
                forceBook.get(side).add(user);

            } else if (input.contains(" -> ")) {
                String[] data = input.split(" -> ");
                String user = data[0];
                String side = data[1];

                if (forceBook.entrySet().stream().noneMatch(e -> e.getValue().contains(user))) {
                    forceBook.get(side).add(user);
                    System.out.println(String.format("%s joins the %s side!", user, side));
                } else {
                    for (Map.Entry<String, Set<String>> current : forceBook.entrySet()) {
                            current.getValue().remove(user);
                    }
                    forceBook.get(side).add(user);
                    System.out.println(String.format("%s joins the %s side!", user, side));
                }
            }
            input = reader.readLine();
        }
        forceBook.entrySet().stream()
                .sorted((s1, s2) -> {
                    int sort = Integer.compare(s1.getValue().size(), s2.getValue().size());

                    if (sort == 0) {
                        sort = s1.getKey().compareTo(s2.getKey());
                    }
                    return sort;
                })
                .forEach(e -> {
                    if (e.getValue().size() > 0) {
                        System.out.println(String.format("Side: %s, Members: %d", e.getKey(), e.getValue().size()));
                    }
                    e.getValue().stream()
                            .forEach(s -> {
                                System.out.println(String.format("! %s", s));
                            });
                });
    }
}
