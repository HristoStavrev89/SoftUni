import java.util.*;

public class Exercise_9_Force_Book {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<String, List<String>> force = new TreeMap<>();

        while (!"Lumpawaroo".equals(input = scanner.nextLine())) {
           String arrow = " -> ";
           char pipe = '|';

           if (input.contains(arrow)) {
               String[] data = input.split(" -> ");
               String name = data[0];
               String side = data[1];

               if (force.entrySet().stream().noneMatch(e -> e.getValue().contains(name))) {
                   force.get(side).add(name);
               } else {
                   force.get(side).add(name);
                   System.out.println(String.format("%s joins the %s side!",name, side));
               }
           } else {
               String[] data = input.split(" \\| ");
               String name = data[0];
               String side = data[1];
               if (!force.containsKey(side)) {
                   force.put(side, new ArrayList<>());
                   force.get(side).add(name);
               } else if (!force.get(side).contains(name)) {
                   force.get(side).add(name);
               }

           }
        }
        System.out.println();


    }
}
