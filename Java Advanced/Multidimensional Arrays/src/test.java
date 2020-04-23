import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int degrees = Integer.parseInt(scanner.nextLine());

        System.out.println(degrees % 360);


    }
}
