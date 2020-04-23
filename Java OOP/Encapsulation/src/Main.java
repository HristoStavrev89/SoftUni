

import shopping.Person;
import shopping.Product;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] inputPeople = scanner.nextLine().split(";");
        Map<String, Person> persons = new LinkedHashMap<>();


        for (int i = 0; i < inputPeople.length; i++) {
            String[] currentPerson = inputPeople[i].split("=");
            String name = currentPerson[0];
            double money = Double.parseDouble(currentPerson[1]);
            try {
                Person per = new Person(name, money);
                persons.putIfAbsent(name, per);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] inputProducts = scanner.nextLine().split(";");
        Map<String, Product> products = new LinkedHashMap<>();


        for (int i = 0; i < inputProducts.length; i++) {
            String[] currentProducts = inputProducts[i].split("=");
            String name = currentProducts[0];
            double money = Double.parseDouble(currentProducts[1]);
            try {
                Product pro = new Product(name, money);
                products.putIfAbsent(name, pro);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }


        String input = "";

        while (!"END".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");
            String namePerson = data[0];
            String productName = data[1];
            if (products.containsKey(productName) && persons.containsKey(namePerson)) {
                persons.get(namePerson).buyProduct(products.get(productName));

            }
        }







    }
}
