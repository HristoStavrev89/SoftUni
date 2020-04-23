import java.util.*;

public class MakeASalad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        tomato	80
//        carrot	136
//        lettuce	109
//        potato	215



        ArrayDeque<String> vegetables = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(vegetables::offer);


        ArrayDeque<Integer> salads = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(salads::push);

        while (!salads.isEmpty() && !vegetables.isEmpty()) {

            int currentSalad = salads.peek();


            while (currentSalad > 0 && !vegetables.isEmpty()) {

                String veggie = vegetables.poll();

                if (veggie.equals("tomato")) {
                    currentSalad -= 60;
                } else if (veggie.equals("carrot")) {
                    currentSalad -= 136;
                } else if (veggie.equals("lettuce")) {
                    currentSalad -= 109;
                } else if (veggie.equals("potato")) {
                    currentSalad -= 215;
                }
            }
            System.out.print(salads.pop() + " ");
        }
        System.out.println();

        if(!salads.isEmpty()){
            System.out.println(salads.toString().replaceAll("[\\[\\],]",""));
        }

        if(!vegetables.isEmpty()){
            System.out.println(vegetables.toString().replaceAll("[\\[\\],]",""));
        }

    }
}
