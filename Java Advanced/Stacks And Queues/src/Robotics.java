import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        String[] input = scanner.nextLine().split(";");

        String[] robots = new String[input.length];
        int[] processTime = new int[input.length];
        int[] workTime = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            String[] data = input[i].split("-");
            String name = data[0];
            int time = Integer.parseInt(data[1]);
            robots[i] = name;
            processTime[i] = time;

        }

        String[] startTime = scanner.nextLine().split(":");

        ArrayDeque<String> products = new ArrayDeque<>();

        String inputProduct = scanner.nextLine();

        while (!inputProduct.equals("End")) {
            products.offer(inputProduct);

            inputProduct = scanner.nextLine();
        }

        int hours = Integer.parseInt(startTime[0]);
        int mins = Integer.parseInt(startTime[1]);
        int secs = Integer.parseInt(startTime[2]);

        LocalTime time = LocalTime.of(hours, mins, secs);

        while (!products.isEmpty()) {
           time = time.plusSeconds(1);

            String product = products.poll();
            boolean isAssigned = false;
            for (int i = 0; i < robots.length; i++) {
                if (workTime[i] == 0 && !isAssigned) {
                    workTime[i] = processTime[i];
                    isAssigned = true;
                    printRobotData(robots[i], product, time);
                }
                if (workTime[i] > 0) {
                    workTime[i]--;
                }
            }
            if (!isAssigned) {
                products.offer(product);
            }
        }





    }

    private static void printRobotData(String robot, String product,LocalTime time) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println(robot + " - " + product + " [" + time.format(formatter) + "]");
    }
}
