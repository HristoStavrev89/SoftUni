import java.util.*;

public class Lab_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Map<String, List<String>>> world = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String continent = data[0];
            String country = data[1];
            String city = data[2];

            if (!world.containsKey(continent)) {
                world.put(continent, new LinkedHashMap<>());
                world.get(continent).put(country, new ArrayList<>());
            } else if (!world.get(continent).containsKey(country)) {
                world.get(continent).put(country, new ArrayList<>());
            }
            world.get(continent).get(country).add(city);



        }



        world.entrySet().stream()
                .forEach(continent -> {
                    System.out.println(String.format("%s:",continent.getKey()));

                    continent
                            .getValue()
                            .entrySet()
                            .stream()
                            .forEach(country -> {
                                System.out.print(String.format("  %s -> ",country.getKey()));


                                for (int i = 0; i < country.getValue().size(); i++) {
                                    if (i == country.getValue().size() - 1) {
                                        System.out.print(country.getValue().get(i));
                                    } else {
                                        System.out.print(country.getValue().get(i) + ", ");
                                    }
                                }

                                System.out.println();


                            });



                });




    }
}
