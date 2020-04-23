import java.util.Scanner;

public class Ivanovis_Holiday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int overnights = Integer.parseInt(scanner.nextLine());
        String destination = scanner.nextLine().toLowerCase();
        String transport = scanner.nextLine().toLowerCase();
        double destinatinResult = 0;
        double transportPrice = 0;


        if (destination.equals("miami")) {
          if (overnights <= 10) {
              destinatinResult = (overnights * (2 * 24.99 + 3 * 14.99));
          } else if (overnights <= 15) {
              destinatinResult = (overnights * (2 * 22.99 + 3 * 11.99));
          } else {
              destinatinResult = (overnights * (3 * 20.00 + 3 * 10.00));
          }
        } else if (destination.equals("canary islands")) {
            if (overnights <= 10) {
                destinatinResult = (overnights * (2 * 32.50 + 3 * 28.50));
            } else if (overnights <= 15) {
                destinatinResult = (overnights * (2 * 30.50 + 3 * 25.60));
            } else  {
                destinatinResult = (overnights * (2 * 28.00 + 3 * 22.00));
            }
        } else if (destination.equals("philippines")) {
            if (overnights <= 10) {
                destinatinResult = (overnights *(2 * 42.99 + 3 * 39.99));
            } else if (overnights <= 15) {
                destinatinResult = (overnights *(2 * 41.00 + 3 * 36.00));
            } else  {
                destinatinResult = (overnights * (2 * 38.50 + 3 * 32.40));
            }
        }
        double destinationPrice = destinatinResult + (destinatinResult * 0.25);

        if (transport.equals("train")) {
            transportPrice = 2 * 22.30 + 3 * 12.50;
        } else if (transport.equals("bus")) {
            transportPrice = 2 * 45.00 + 3 * 37.00;
        } else if (transport.equals("airplane")) {
            transportPrice = 2 * 90.00 + 3 * 68.50;
        }

double total = destinationPrice + transportPrice;

        System.out.printf("%.3f",total);



    }
}
