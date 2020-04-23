import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        String input = "";
        Map<String, Integer> results = new LinkedHashMap<>();
        Map<String, Integer> submissions = new LinkedHashMap<>();

        while (!"exam finished".equals(input = scanner.nextLine())) {
            String[] data = input.split("-");

            if (data.length == 2) {
                    if (results.containsKey(data[0])) {
                        results.remove(data[0]);

                    }

            } else if (data.length > 2) {
                String name = data[0];
                String language = data[1];
                int points = Integer.parseInt(data[2]);

                if (!results.containsKey(name)) {
                    results.put(name, points);
                } else {
                    results.put(name, points);
                }

                if (!submissions.containsKey(language)) {
                    submissions.put(language, 1);
                } else {
                    submissions.put(language, submissions.get(language) + 1);
                }
            }
        }

        System.out.println("Results:");

        results.entrySet().stream()
                .sorted((e1, e2) -> {
                   int sort = Integer.compare(e2.getValue(), e1.getValue());

                   if (sort == 0) {
                       sort = e1.getKey().compareTo(e2.getKey());
                   }
                   return sort;
                }).forEach(kvp -> {
            System.out.println(String.format("%s | %d", kvp.getKey(), kvp.getValue()));
        });
        System.out.println("Submissions:");
        submissions.entrySet().stream()
                .sorted((s1, s2) -> {
                    int sort = Integer.compare(s2.getValue(), s1.getValue());

                    if (sort == 0) {
                        sort = s1.getKey().compareTo(s2.getKey());
                    }
                    return sort;
                }).forEach(submit -> {
            System.out.println(String.format("%s - %d", submit.getKey(), submit.getValue()));
        });





    }
}
