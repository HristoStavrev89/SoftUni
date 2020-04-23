import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SummerCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);




        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(ingredients::offer);


        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(freshness::push);


        int mimosa = 0;
        int daiquiri = 0;
        int sunshine = 0;
        int mojito = 0;


        while (!ingredients.isEmpty() && !freshness.isEmpty()) {


            int incredient = ingredients.pop();
            int fresh = freshness.peek();

            int currentCocktail = incredient * fresh;

            boolean isItready = false;

            while (!isItready) {
                if (incredient == 0) {
                    ingredients.poll();
                    break;
                }
                if (currentCocktail == 150) {
                    ingredients.poll();
                    freshness.pop();
                    mimosa++;
                    isItready = true;
                } else if (currentCocktail == 250) {
                    ingredients.poll();
                    freshness.pop();
                    daiquiri++;
                    isItready = true;
                } else if (currentCocktail == 300) {
                    ingredients.poll();
                    freshness.pop();
                    sunshine++;
                    isItready = true;
                } else if (currentCocktail == 400) {
                    ingredients.poll();
                    freshness.pop();
                    mojito++;
                    isItready = true;
                } else {
                    if (freshness.isEmpty()) {
                        break;
                    }
                    freshness.pop();
                    incredient += 5;

                    ingredients.offer(incredient);


                }

            }

        }

        int sum = ingredients.stream()
                .mapToInt(Integer::intValue).sum();

        if (mimosa > 0 && daiquiri > 0 && sunshine > 0 && mojito > 0) {
            System.out.println("It's party time! The cocktails are ready!");
            System.out.println(" # Daiquiri --> " + daiquiri);
            System.out.println(" # Mimosa --> " + mimosa);
            System.out.println(" # Mojito --> " + mojito);
            System.out.println(" # Sunshine --> " + sunshine);
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");

            System.out.println("Ingredients left: " + sum);
            if (daiquiri > 0) {
                System.out.println(" # Daiquiri --> " + daiquiri);
            } else if (mimosa > 0) {
                System.out.println(" # Mimosa --> " + mimosa);
            } else if (mojito > 0) {
                System.out.println(" # Mojito --> " + mojito);
            } else if (sunshine > 0) {
                System.out.println(" # Sunshine --> " + sunshine);
            }
        }




    }
}

