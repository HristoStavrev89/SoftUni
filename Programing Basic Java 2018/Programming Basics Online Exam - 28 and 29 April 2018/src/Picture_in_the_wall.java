import java.util.Scanner;

public class Picture_in_the_wall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int widthSize = Integer.parseInt(scanner.nextLine());
        int lenghtSize = Integer.parseInt(scanner.nextLine());
        int side = Integer.parseInt(scanner.nextLine());
        int num = Integer.parseInt(scanner.nextLine());

        int holeSize = widthSize * lenghtSize;
        int picsSize = (side * side) * num;
        int result = 0;

        if (holeSize > picsSize) {
            result = holeSize - picsSize;
            System.out.printf("The pictures fit in the hole. Hole area is %d bigger than pictures area.",result);
        } else {
            result = picsSize - holeSize;
            System.out.printf("The pictures don't fit in the hole. Picture area is %d bigger than hole area.",result);

        }


    }
}
