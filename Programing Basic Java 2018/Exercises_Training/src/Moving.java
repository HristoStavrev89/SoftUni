import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int lenght = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        int boxs = 0;


        int space = width * lenght * height;

        while (space >= boxs) {
            int n = Integer.parseInt(scanner.nextLine());
            boxs += n;

        }
        if (space >= boxs) {
            int freeSpace = space - boxs;
            System.out.println(freeSpace + " Cubic meters left.");
        } else {
            int leftSpace = boxs - space;
            System.out.println("No more free space! You need " + leftSpace + " Cubic meters more.");
        }


    }
}
