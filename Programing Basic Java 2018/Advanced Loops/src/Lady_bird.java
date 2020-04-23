import java.util.Scanner;

public class Lady_bird {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
         // First Part!
        // 1 row
        System.out.println(repeatStr(" ", n - 2) + "@   @");
        // 2 row
        System.out.println(repeatStr(" ", n -1) + "\\_/");
        //3 row
        System.out.println(repeatStr(" ",n - 1) + "/ \\");
        //4 row
        System.out.println(repeatStr(" ", n - 1) + "|_|");



        // Second Part
        for (int i = 0; i < n; i++) {
            System.out.println(repeatStr(" ", n - 1 - i)
            + "/"
            + repeatStr(" ", i)
            + "|"
            + repeatStr(" ", i)
            + "\\");

            }

            //Third Part
        String odd = "|"
                + repeatStr(" ",n / 2 -1)
                + "@"
                + repeatStr(" ",n /2)
                + "|"
                + repeatStr(" ",n /2)
                + "@"
                + repeatStr(" ",n / 2 -1)
                + "|";

        String even = "|"
                + repeatStr(" ",n / 2 -1)
                + "@"
                + repeatStr(" ",n /2 - 1)
                + "|"
                + repeatStr(" ",n /2 - 1)
                + "@"
                + repeatStr(" ",n / 2 -1)
                + "|";

        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                System.out.println(even);
            }
            for (int i = 0; i < n -2 ; i++) {
                System.out.println(repeatStr(" ", i)
                + "\\"
                + repeatStr(" ", n -1 - i)
                + "|"
                + repeatStr(" ",n - 1 - i)
                + "/");
            }
            System.out.println(repeatStr(" ",n/2)
            + repeatStr("^",n/2)
            + "|"
            + repeatStr("^",n /2 ));


        } else {
            for (int i = 0; i < n / 2 ; i++) {
                System.out.println(odd);
            }

            for (int i = 0; i < n / 2; i++) {
                System.out.println(repeatStr(" ",i)
                + repeatStr(" ",n-1-i)
                + "|"
                +repeatStr(" ",n-1-i)
                + "/");
            }
            System.out.println(repeatStr(" ",n / 2 +1)
            + repeatStr("^",n / 2)
            + "|"
            + repeatStr("^",n / 2));

        }














    }
    static String repeatStr (String text, int count) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count ; i++) {
            result.append(text);
        }
        return result.toString();
    }
}
