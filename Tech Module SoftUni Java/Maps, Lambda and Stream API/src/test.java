import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = "";
        Map<String, List<String>> courses = new HashMap<>();

        while (!"end".equals(input = scanner.nextLine())) {
            String[] data = input.split(" : ");

            String course = data[0];
            String student = data[1];

            courses.putIfAbsent(course, new ArrayList<>());
            courses.get(course).add(student);

        }



        courses
                .entrySet()
                .stream()
                .sorted((s1, s2) ->
                    Integer.compare(s2.getValue().size(), s1.getValue().size())
                ).forEach(e -> {
            System.out.println(String.format("%s: %d", e.getKey(), e.getValue().size()));

            // Printing the names from the current course.
            e.getValue().stream()
                    .sorted((e1, e2) ->
                        e1.compareTo(e2))
                    .forEach(f -> {
                System.out.println(String.format("-- %s", f));
            });
        });

    }
}
