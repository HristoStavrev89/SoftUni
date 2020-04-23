import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int half = (n * 50) / 100;

        while (m <= n) {
            count++;
            n -= m;

            if (half == n) {
                n/=y;
            }



        }
        System.out.println(n);
        System.out.println(count);





    }
}
