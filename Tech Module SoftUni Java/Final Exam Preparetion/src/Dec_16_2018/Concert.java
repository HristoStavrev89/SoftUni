package Dec_16_2018;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Concert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);


        String input = "";
        String namesMatcher = "(?<member>[A-Za-z]+ [A-Za-z]+)";
        Pattern pattern = Pattern.compile(namesMatcher);

        Map<String, ArrayList<String>> bands = new LinkedHashMap<>();
        Map<String, Integer> playingTime = new LinkedHashMap<>();

        int totalTime = 0;

        while (!"start of concert".equals(input = scanner.nextLine())) {
            String[] data = input.split("; ");
            String command = data[0];
            String bandName = data[1];

            if (command.equals("Add")) {
                if (!bands.containsKey(bandName)) {
                    bands.put(bandName, new ArrayList<>());
                }

                int cutIndex = input.lastIndexOf("; ");
                String cutting = input.substring(cutIndex);
                Matcher matcher = pattern.matcher(cutting);

                while (matcher.find()) {
                    String name = matcher.group();


                    if (!bands.get(bandName).contains(name)) {
                        bands.get(bandName).add(name);
                    }
                }

            }
            if (command.equals("Play")) {
                int time = Integer.parseInt(data[2]);
                if (!playingTime.containsKey(bandName)) {

                    playingTime.put(bandName, time);
                    totalTime += time;
                } else {
                    playingTime.put(bandName, playingTime.get(bandName) + time);
                    totalTime += time;
                }
            }

        }
        String bandName = scanner.nextLine();

        System.out.println("Total time: " + totalTime);

        playingTime.entrySet().stream()
                .sorted((b1, b2) -> {
                    int sort = Integer.compare(b2.getValue(), b1.getValue());

                    if (sort == 0) {
                        sort = b1.getKey().compareTo(b2.getKey());
                    }

                    return sort;
                }).forEach(kvp -> {
            System.out.println(String.format("%s -> %d",kvp.getKey(), kvp.getValue()));
        });


        List<String> allMembers = bands.get(bandName);

        System.out.println(bandName);
        allMembers.stream()
                .forEach(e -> {
                    System.out.println(String.format("=> %s", e));
                });



    }
}
