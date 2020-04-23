import java.util.Scanner;

public class Buss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startPassagers = Integer.parseInt(scanner.nextLine());
        int bussStops = Integer.parseInt(scanner.nextLine());
       // int firstStop = startPassagers;
        int arrival = 0;
        int departure = startPassagers;



        for (int i = 1; i <= bussStops; i++) {

            int out = Integer.parseInt(scanner.nextLine());
            int in = Integer.parseInt(scanner.nextLine());

            departure -= out;
            arrival += in;


            if (i % 2 != 0) {
                arrival += 2;
            } else if (i % 2 == 0) {
                in += 2;
            }


        }
        int result = arrival + departure - bussStops;

        if (result % 2 != 0) {
            //result += 1;
            System.out.println("The final number of passengers is : " + result);
        } else {
            result += 1;
            System.out.println("The final number of passengers is : " + result);
        }




    }
}
