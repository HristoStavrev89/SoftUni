import java.util.Scanner;

public class ConcatenataData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName  = scanner.nextLine();
        int    years       = Integer.parseInt(scanner.nextLine());
        String town      = scanner.nextLine();

        System.out.println("You are "+firstName+" "+lastName+", a "+years+"-years old person from "+town+".");

    }
}

