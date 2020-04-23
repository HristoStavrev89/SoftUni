package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnimalSanctuary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String regex = "(?<name>.+);(?<character>.+);(?<country>[A-Za-z][-]+[A-Za-z]+)";
        Pattern pattern = Pattern.compile(regex);

        int n = Integer.parseInt(scanner.nextLine());

        int totalWeight = 0;

        for (int i = 0; i < n; i++) {
            String data = scanner.nextLine();

            Matcher matcher = pattern.matcher(data);

            String nameCode = "";
            String anmalKind = "";
            String animalCountry = "";

            while (matcher.find()) {
                nameCode = matcher.group("name");
                anmalKind = matcher.group("character");
                animalCountry = matcher.group("country");
            }

            if (nameCode.length() < 3) {
                continue;
            }

            if (anmalKind.length() != 0 && animalCountry.length() != 0) {

                StringBuilder name = new StringBuilder();
                int weight = 0;


                String decode = nameCode.substring(2);
                String kindDecode = anmalKind.substring(2);
                StringBuilder kind = new StringBuilder();
                int indexLine = animalCountry.lastIndexOf("-") + 1;
                String countryDecode = animalCountry.substring(indexLine);


                for (int j = 0; j < decode.length(); j++) {
                    if (Character.isAlphabetic(decode.charAt(j))) {
                        name.append(decode.charAt(j));
                    } else if (Character.isDigit(decode.charAt(j))) {
                        int num = Character.getNumericValue(decode.charAt(j));
                        weight += num;
                    }
                }


                for (int j = 0; j < kindDecode.length(); j++) {
                    if (Character.isAlphabetic(kindDecode.charAt(j))) {
                        kind.append(kindDecode.charAt(j));
                    } else if (Character.isDigit(kindDecode.charAt(j))) {
                        int num = Character.getNumericValue(kindDecode.charAt(j));
                        weight += num;
                    }
                }



                totalWeight += weight;

                System.out.println(String.format("%s is a %s from %s",name,kind,countryDecode));


            }

        }


        System.out.println("Total weight of animals: " + totalWeight + "KG");



    }
}
