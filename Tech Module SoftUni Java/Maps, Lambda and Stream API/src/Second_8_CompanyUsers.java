import java.util.*;

public class Second_8_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> users = new TreeMap<>();

        String input = "";

        while (!"End".equals(input = scanner.nextLine())) {
            String[] data = input.split(" -> ");

            String company = data[0];
            String user = data[1];


            if (!users.containsKey(company)) {
                users.put(company, new ArrayList<>());
                users.get(company).add(user);
            } else if (!users.get(company).contains(user)) {
                users.get(company).add(user);
            }

        }

        users.entrySet()
                .stream().forEach(e -> {
            System.out.println(String.format("%s",e.getKey()));
            e.getValue().stream().forEach(c -> {
                System.out.println(String.format("-- %s",c));
            });
        });


    }
}
