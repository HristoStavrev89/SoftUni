import java.util.*;

public class Second_3_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> legendary = new TreeMap<>();
        Map<String, Integer> junks = new TreeMap<>();

        legendary.put("shards", 0);
        legendary.put("fragments", 0);
        legendary.put("motes", 0);

        boolean exit = false;

        while (!exit) {
            String[] input = scanner.nextLine().split("\\s+");

            String material = "";
            int value = 0;
            for (int i = 0; i < input.length; i += 2) {
                 value = Integer.parseInt(input[i]);
                 material = input[i + 1].toLowerCase();

                if (material.equals("shards")) {
                    legendary.put(material, legendary.get(material) + value);
                    if (legendary.get(material) >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        legendary.put(material, legendary.get(material) - 250);
                        exit = true;
                        break;
                    }
                } else if (material.equals("fragments")) {
                    legendary.put(material, legendary.get(material) + value);
                    if (legendary.get(material) >= 250) {
                        System.out.println("Valanyr obtained!");
                        legendary.put(material, legendary.get(material) - 250);
                        exit = true;
                        break;
                    }
                } else if (material.equals("motes")) {
                    legendary.put(material, legendary.get(material) + value);
                    if (legendary.get(material) >= 250) {
                        System.out.println("Dragonwrath obtained!");
                        legendary.put(material, legendary.get(material) - 250);
                        exit = true;
                        break;
                    }
                } else {
                    if (!junks.containsKey(material)) {
                        junks.put(material, value);
                    } else {
                        junks.put(material, junks.get(material) + value);
                    }
                }
            }
        }
        legendary
                .entrySet()
                .stream()
                .sorted((e1,e2) -> Integer.compare(e2.getValue(),e1.getValue()))
                .forEach(item -> {
                    System.out.println(String.format("%s: %d",item.getKey(),item.getValue()));
                });

        junks
                .entrySet()
                .stream()
                .sorted((e1,e2) -> e1.getKey().compareTo(e2.getKey()))
                .forEach(item -> {
                    System.out.println(String.format("%s: %d",item.getKey(),item.getValue()));
                });



    }
}
