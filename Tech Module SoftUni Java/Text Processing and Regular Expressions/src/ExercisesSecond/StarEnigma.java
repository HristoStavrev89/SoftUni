package ExercisesSecond;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        String keyValue = "[SsTtAaRr]";
        Pattern patternKey = Pattern.compile(keyValue);

        String starEnigma = "(.*?)@(?<name>[A-Z][a-z]+)(.*?):(?<population>[0-9]+)(.*?)!(?<attackType>[A|D])!(.*?)->(.*?)(?<soldiersCount>\\d+)";
        Pattern starPattern = Pattern.compile(starEnigma);

        int key = 0;
      //  String decrypted = "";


        List<String> attackPlanets = new ArrayList<>();
        List<String> destroyingPlanets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String encrypted = scanner.nextLine();
            String decrypted = "";

            Matcher keyMatcher = patternKey.matcher(encrypted);


            // Key founding
            while (keyMatcher.find()) {
                key++;
            }

            //decrypt the messege
            for (int j = 0; j < encrypted.length(); j++) {
                char current = encrypted.charAt(j);
                int number = current - key;
                char next = (char) number;
                decrypted += next;
            }
            System.out.println();
            String planetType = "";
            String planetname = "";

            Matcher planetMatcher = starPattern.matcher(decrypted);

            while (planetMatcher.find()) {
                planetType = planetMatcher.group("attackType");
                planetname = planetMatcher.group("name");
            }


                if (planetType.equals("A")) {
                    attackPlanets.add(planetname);
                }
                if (planetType.equals("D")) {
                    destroyingPlanets.add(planetname);
                }


                key = 0;



        }

        destroyingPlanets.sort(String::compareToIgnoreCase);
        attackPlanets.sort(String::compareToIgnoreCase);

        System.out.printf("Attacked planets: %d\n",attackPlanets.size());
        if (attackPlanets.size() > 0) {
            for (String planet : attackPlanets) {
                System.out.println(String.format("-> %s",planet));
            }
        }
        System.out.println(String.format("Destroyed planets: %d", destroyingPlanets.size()));
        if (destroyingPlanets.size() > 0) {
            for (String planet : destroyingPlanets) {
                System.out.println(String.format("-> %s",planet));
            }
        }


    }
}
