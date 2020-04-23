import java.util.Scanner;

public class Sun_Glasses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        String firstRow = repeatStr("*", n * 2)
                + repeatStr(" ",n)
                + repeatStr("*",n * 2);
        System.out.println(firstRow);





    }

    static String repeatStr(String text, int count) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            result.append(text);
        }
        return result.toString();
    }
}
