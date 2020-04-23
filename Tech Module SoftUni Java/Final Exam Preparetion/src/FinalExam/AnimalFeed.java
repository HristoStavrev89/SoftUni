package FinalExam;

import java.util.*;

public class AnimalFeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";
        Map<String, Integer> animals = new LinkedHashMap<>();
        Map<String, List<String>> location = new LinkedHashMap<>();

        while (!"Last Info".equals(input = scanner.nextLine())) {
            String[] data = input.split(":");
            String command = data[0];

            if (command.equals("Add")) {
                String animalName = data[1];
                int dailyFoodLimit = Integer.parseInt(data[2]);
                String area = data[3];
                if (!animals.containsKey(animalName)) {
                    animals.put(animalName, dailyFoodLimit);
                } else {
                    animals.put(animalName, animals.get(animalName) + dailyFoodLimit);
                }
                if (!location.containsKey(area)) {
                    location.put(area, new ArrayList<>());
                    location.get(area).add(animalName);
                } else {
                    if (!location.get(area).contains(animalName)) {
                        location.get(area).add(animalName);
                    }
                }
            }
            if (command.equals("Feed")) {
                String anmalName = data[1];
                int food = Integer.parseInt(data[2]);
                String area = data[3];
                boolean delete = false;
                if (animals.containsKey(anmalName)) {
                    animals.put(anmalName, animals.get(anmalName) - food);
                    for (Map.Entry<String, Integer> animal : animals.entrySet()) {
                        if (animal.getValue() <= 0 ) {
                            System.out.println(String.format("%s was successfully fed",animal.getKey()));
                           delete = true;
                        }
                    }
                }
                if (delete) {
                    animals.remove(anmalName);
                  location.get(area).remove(anmalName);
                }
            }
        }
        System.out.println("Animals:");
        animals.entrySet().stream()
                .sorted((a1, a2) -> {
                    int sort = Integer.compare(a2.getValue(),a1.getValue());

                    if (sort == 0) {
                        sort = a1.getKey().compareTo(a2.getKey());
                    }
                    return sort;
                }).forEach(kvp -> {
            System.out.println(String.format("%s -> %dg",kvp.getKey(),kvp.getValue()));
        });
        System.out.println("Areas with hungry animals:");
        location.entrySet().stream()
                .filter(e -> e.getValue().size() > 0)
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue().size(),e1.getValue().size());
                    return sort;
                }).forEach(a -> {
            System.out.println(String.format("%s : %d",a.getKey(), a.getValue().size()));
        });






    }
}
