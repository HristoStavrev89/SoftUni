import java.util.Scanner;

public class train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        int[] train = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int wagons = Integer.parseInt(scanner.nextLine());
            sum += wagons;
            train[i] = wagons;
        }

        for (int vlak : train) {
            System.out.print(vlak + " ");
        }
        System.out.println();
        System.out.println(sum);

    }
}
