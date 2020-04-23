import java.util.*;

public class Exercise_3_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new TreeMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        Map<String, Integer> junk = new TreeMap<>();

        String winner = "";
        boolean flag = false;

        do {
            String[] data = scanner.nextLine().toLowerCase().split("\\s+");

            for (int i = 0; i < data.length; i += 2) {
                int quantuty = Integer.parseInt(data[i]);
                String material = data[i + 1].toLowerCase();

                if (!keyMaterials.containsKey(material)) {
                    if (!junk.containsKey(material)) {
                        junk.put(material, quantuty);
                    } else {
                        junk.put(material, junk.get(material) + quantuty);
                    }
                } else {
                    keyMaterials.put(material, keyMaterials.get(material) + quantuty);

                    if (keyMaterials.get(material) >= 250) {
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        winner = material;
                        flag = true;
                        break;
                    }

                }
            }
        } while (!flag);

        if (winner.equals("shards")) {
            System.out.println("Shadowmourne obtained!");
        } else if (winner.equals("motes")) {
            System.out.println("Dragonwrath obtained!");
        } else if (winner.equals("fragments")) {
            System.out.println("Valanyr obtained!");
        }


        keyMaterials
                .entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int sort = Integer.compare(e2.getValue(),
                            e1.getValue());
                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                }).forEach((e -> {
            System.out.println(String.format(
                    "%s: %d", e.getKey(), e.getValue()
            ));
        }));


        junk.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> {
                    System.out.println(String.format(
                            "%s: %d", e.getKey(), e.getValue()
                    ));
                });


    }
}
