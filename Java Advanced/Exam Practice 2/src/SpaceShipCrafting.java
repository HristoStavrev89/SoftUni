import java.util.*;

public class SpaceShipCrafting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(l -> liquids.offer(l));

        ArrayDeque<Integer> items = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(i -> items.push(i));

//        System.out.println(liquids.peek());
//        System.out.println(items.peek());

        // increase the value of the item
//        int test = items.pop() + 3;
//        items.push(test);



        int glass = 25;
        int aluminium = 50;
        int lithium = 75;
        int carbonFiber = 100;

        int glassCraftet = 0;
        int aluminiumCraftet = 0;
        int lithiumCrafted = 0;
        int carbonFiberCrafted = 0;


        while (true) {

            int result = liquids.peek() + items.peek();

            if (result == glass) {
                items.pop();
                liquids.poll();
                glassCraftet++;
            } else if (result == aluminium) {
                items.pop();
                liquids.poll();
                aluminiumCraftet++;
            } else if (result == lithium) {
                items.pop();
                liquids.poll();
                lithiumCrafted++;
            } else if (result == carbonFiber) {
                items.pop();
                liquids.poll();
                carbonFiberCrafted++;
            } else {
                liquids.poll();
                int increaseValue = items.pop() + 3;
                items.push(increaseValue);
            }
            if (liquids.isEmpty()) {
                break;
            } else if (items.isEmpty()) {
                break;
            }
        }


        if (glassCraftet > 0 && aluminiumCraftet > 0 && lithiumCrafted > 0 && carbonFiberCrafted > 0) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }

        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            String liquidsToString = liquids.toString().replaceAll("[\\[\\]]","");
            System.out.println("Liquids left: " + liquidsToString);

        }

        if (items.isEmpty()) {
            System.out.println("Physical items left: none");
        } else {
            String itemsToString = items.toString().replaceAll("[\\[\\]]","");
            System.out.println("Physical items left: " + itemsToString);

        }

        System.out.println("Aluminium: " + aluminiumCraftet);
        System.out.println("Carbon fiber: " + carbonFiberCrafted);
        System.out.println("Glass: " + glassCraftet);
        System.out.println("Lithium: " + lithiumCrafted);

    }
}
