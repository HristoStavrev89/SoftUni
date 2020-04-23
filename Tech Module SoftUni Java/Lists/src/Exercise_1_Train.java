import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise_1_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        int maxCapacity = Integer.parseInt(scanner.nextLine());


        while (true) {
            String line = scanner.nextLine();

            if (line.equals("end")) {
                break;
            }

            String[] tokens = line.split(" ");

           if (tokens[0].equals("Add")) {
               int passangers = Integer.parseInt(tokens[1]);
               wagons.add(passangers);
           } else {
               int number = Integer.parseInt(tokens[0]);

               for (int i = 0; i < wagons.size(); i++) {
                   int currentWagon = wagons.get(i);

                   if (number + currentWagon <= maxCapacity) {
                       wagons.set(i, number + currentWagon);
                       break;
                   }


               }

           }



        }

        System.out.println(wagons.toString().replaceAll("[\\[,\\]]",""));








    }
}
