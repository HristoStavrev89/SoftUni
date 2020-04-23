import java.util.Scanner;

public class Cat_Watch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int skoba = 3 * (n - 2) / 2;


        for (int i = 0; i < n - 2; i++) {
            String firstPart = repeatStr(" ", n = n)
                    + "||"
                    + repeatStr("_", n - 2)
                    + "||";
            System.out.println(firstPart);
        }
        String secondPart = repeatStr(" ", n - 1)
                + "//"
                + repeatStr(" ", n = n)
                + "\\\\";
        System.out.println(secondPart);

        for (int i = 0; i < n - 4; i++) {
            String thirdPart = repeatStr(" ", n - 2)
                    + "||"
                    + repeatStr(" ", n + 2)
                    + "||";
            if (n % 2 == 0) {
                repeatStr("]",(n / 2) - 1);
                System.out.println(thirdPart);
            } else {
                repeatStr("]",n / 2);
                System.out.println(thirdPart);
            }



        }



        String fourthPart = repeatStr(" ", n - 1)
                + "\\\\"
                + repeatStr(" ", n = n)
                + "//";
        System.out.println(fourthPart);

        for (int i = 0; i < n - 2; i++) {
            String fifthParth = repeatStr(" ", n = n)
                    + "||"
                    + repeatStr("_", n - 2)
                    + "||";
            System.out.println(fifthParth);
        }

    }

    static String repeatStr(String text, int count) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            result.append(text);
        }
        return result.toString();
    }
}
