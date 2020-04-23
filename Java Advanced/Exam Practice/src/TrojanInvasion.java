import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class TrojanInvasion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        // number of trojan warriors
        int waves = Integer.parseInt(scanner.nextLine());


        // defense plates
        ArrayDeque<Integer> defense = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(defense::offer);


        for (int i = 1; i <= waves; i++) {
//            int[] warriors = Arrays.stream(scanner.nextLine().split("\\s+"))
//                    .mapToInt(Integer::parseInt).toArray();

            ArrayDeque<Integer> warriors = new ArrayDeque<>();
            Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Integer::parseInt).forEach(warriors::push);

            if (i % 3 == 0) {
                int newPlate = Integer.parseInt(scanner.nextLine());
                defense.offer(newPlate);

            }



            int currentPlate = defense.peek();

            while (!warriors.isEmpty()) {

                int currentWarrior = warriors.peek();

                int fight = currentPlate - currentWarrior;

                if (fight > 0) {
                    defense.poll();
                    defense.push(fight);
                    warriors.pop();
                    currentPlate = defense.peek();
                } else {
                    defense.poll();
                    warriors.pop();
                    if (fight != 0) {
                        warriors.push(currentWarrior - currentPlate);
                    }
                    if (defense.isEmpty()) {
                        System.out.println("The Trojans successfully destroyed the Spartan defense.");
                        System.out.printf("Warriors left: %s%n",
                                String.join(", ", warriors.toString().replaceAll("[\\[\\]]", "")));
                        return;

                    }


                }


            }







        }

        System.out.println("The Spartans successfully repulsed the Trojan attack.");
        System.out.printf("Plates left: %s%n",
                String.join(", ", defense.toString().replaceAll("[\\[\\]]", "")));
    }
}
