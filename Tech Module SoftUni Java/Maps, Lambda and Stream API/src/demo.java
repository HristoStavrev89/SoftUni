import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean ready = false;

        Map<String, Integer> materials = new HashMap<>();
        materials.put("fragments", 0);
        materials.put("shards", 0);
        materials.put("motes", 0);
        Map<String, Integer> junk = new HashMap<>();


        while (!ready) {
            String[] line = scanner.nextLine().split("\\s+");

            for (int i = 0; i < line.length; i += 2) {
                int quantity = Integer.parseInt(line[i]);
                String currentMaterial = line[i + 1].toLowerCase();

                if (currentMaterial.equals("shards") || currentMaterial.equals("motes") || currentMaterial.equals("fragments")) {
                    materials.put(currentMaterial, materials.get(currentMaterial) + quantity);
                    for (Map.Entry<String, Integer> element : materials.entrySet()) {
                        if (element.getValue() >= 250) {
                            materials.put(currentMaterial, materials.get(currentMaterial) - 250);
                            if (element.getKey().equals("shards")) {
                                System.out.println("Shadowmourne obtained!");
                            } else if (element.getKey().equals("fragments")) {
                                System.out.println("Valanyr obtained!");
                            } else if (element.getKey().equals("motes")) {
                                System.out.println("Dragonwrath obtained!");
                            }
                            ready = true;
                        }
                    }
                    if (ready) {
                        break;
                    }
                } else {
                    if (!junk.containsKey(currentMaterial)) {
                        junk.put(currentMaterial, quantity);
                    } else {
                        junk.put(currentMaterial, junk.get(currentMaterial) + quantity);
                    }
                }
            }
        }

        materials
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {

            int sort = Integer.compare(e2.getValue(), e1.getValue());
            if (sort == 0) {
                sort = e1.getKey().compareTo(e2.getKey());
            }
            return sort;
        })
                .forEach(e -> {
            System.out.println(String.format("%s: %d", e.getKey(), e.getValue()));
        });


        junk
                .entrySet()
                .stream()
                .sorted((j1, j2) -> {
                   return j1.getKey().compareTo(j2.getKey());
                })
                .forEach(j -> {
                    System.out.println(String.format("%s: %d" ,j.getKey(), j.getValue()));
                });


    }
}
