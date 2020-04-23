import java.util.*;

public class Exercise_6_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String input = "";

        Map<String, ArrayList<String>> courses = new LinkedHashMap<>();

        while (!"end".equals(input = scanner.nextLine())) {
            String[] data = input.split(" : ");

            String course = data[0];
            String studentName = data[1];

            if (!courses.containsKey(course)) {
                courses.put(course, new ArrayList<>());
                courses.get(course).add(studentName);
            } else {
                courses.get(course).add(studentName);
            }
        }

        courses
                .entrySet()
                .stream()
                .sorted((e1, e2) ->
                        Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(e -> {
                    System.out.println(String.format("%s: %d", e.getKey(), e.getValue().size()));

                    e.getValue().stream().sorted((s, s2) -> s.compareTo(s2))
                            .forEach(p -> System.out.println(String.format("-- %s",p)));
                });



    }
}
