import java.util.Scanner;

public class PCstore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double processor = Double.parseDouble(scanner.nextLine());
        double videoCard = Double.parseDouble(scanner.nextLine());
        double ram = Double.parseDouble(scanner.nextLine());
        double ramCount = Double.parseDouble(scanner.nextLine());
        double discount = Double.parseDouble(scanner.nextLine());

        double processorPrice = processor * 1.57;
        double videoCardPrice = videoCard * 1.57;
        double ramPrice       = (ram * 1.57) * ramCount;
        double processorDiscount = processorPrice - (processorPrice * discount);
        double videoCardDiscount = videoCardPrice - (videoCardPrice * discount);
        double totalPrice = ramPrice + processorDiscount + videoCardDiscount;

        System.out.printf("Money needed - %.2f leva.",totalPrice);



    }
}
