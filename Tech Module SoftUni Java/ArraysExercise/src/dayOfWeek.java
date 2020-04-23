import java.util.Scanner;

public class dayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] days = {"Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"};

        int day = Integer.parseInt(scanner.nextLine());

        if (day > 0 && day < 8) {
            System.out.println(days[day-1]);
        } else {
            System.out.println("Invalid day!");
        }

//        Enter a day number [1…7]
//        and print the day name (in English) or "Invalid day!". Use an array of strings.
    }
}
