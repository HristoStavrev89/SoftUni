import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChoreWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String validator = "(?<dishes><[a-z0-9]+>)|(?<house>\\[[A-Z0-9]+\\])|(?<laundry>[{].+[}])";
        Pattern pattern = Pattern.compile(validator);
        String input = "";
        int dishes = 0;
        int house = 0;
        int laundry = 0;
        while (!"wife is happy".equals(input = scanner.nextLine())) {
            String data = input;
            Matcher checker = pattern.matcher(data);
            if (checker.find()) {
                String found = checker.group();
                if (found.charAt(0) == 123) {
                    laundry += wifeCalculator(found);
                } else if (found.charAt(0) == 91) {
                    house += wifeCalculator(found);
                } else if (found.charAt(0) == 60) {
                    dishes += wifeCalculator(found);
                }
            }
        }
        System.out.println("Doing the dishes - " + dishes + " min.");
        System.out.println("Cleaning the house - " + house + " min.");
        System.out.println("Doing the laundry - " + laundry + " min.");
        System.out.println("Total - " + (dishes + house + laundry) + " min.");
    }
    public static int wifeCalculator (String work) {
        int sum = 0;
        for (int i = 0; i < work.length(); i++) {
               if (work.charAt(i) > 47 && work.charAt(i) < 58) {
                   sum  +=  Character.getNumericValue(work.charAt(i));
               }
        }
        return sum;


    }
}
