package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleOfManTT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        boolean found = true;

        String regex = "(?<symbol>[#$%&*])(?<name>[A-Za-z]+)\\1=(?<number>[0-9]+)!!(?<geohash>.+)";
        Pattern pattern = Pattern.compile(regex);



        while (true) {
            String data = scanner.nextLine();

            String name = "";
            int length = 0;
            String geohash = "";


            Matcher matcher = pattern.matcher(data);

            while (matcher.find()) {
                name = matcher.group("name");
                length = Integer.parseInt(matcher.group("number"));
                geohash = matcher.group("geohash");
            }

            if (name.length() != 0 && length == geohash.length()) {

                StringBuilder decode = new StringBuilder();

                for (int i = 0; i < geohash.length(); i++) {
                    int current =  geohash.charAt(i) + length;
                    char after = (char) current;
                    decode.append(after);

                }


                System.out.println(String.format("Coordinates found! %s -> %s", name, decode));
                return;


            } else {
                System.out.println("Nothing found!");
            }






        }




    }
}
