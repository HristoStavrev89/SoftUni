import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MakeASalad_Second {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<String> products = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(products::offer);

        ArrayDeque<Integer> salads = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(salads::push);




        while (true) {

            int currentSalad = salads.peek();

            String veggie = products.poll();



            if (veggie.equals("tomato")) {
              //  currentSalad -= 80;
                salads.pop();
                salads.push(currentSalad -= 80);
            } else if (veggie.equals("carrot")) {
              //  currentSalad -= 136;
                salads.pop();
                salads.push(currentSalad -= 136);
            } else if (veggie.equals("lettuce")) {
              //  currentSalad -= 109;
                salads.pop();
                salads.push(currentSalad -= 109);
            } else if (veggie.equals("potato")) {
              //  currentSalad -= 215;
                salads.pop();
                salads.push(currentSalad -= 215);
            }

            if (currentSalad <= 0) {
                salads.pop();
            }

            if (products.isEmpty()) {
                break;
            } else if (salads.isEmpty()) {
                break;
            }

        }


        System.out.println();





    }
}
