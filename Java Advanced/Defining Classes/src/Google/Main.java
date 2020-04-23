package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = "";

        Map<String, Person> personMap = new HashMap<>();

        while (!"End".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");

            String name = data[0];
            String object = data[1];

            Person person = new Person();

            if (object.equals("company")) {
                String companyName = data[2];
                String departmentName = data[3];
                String salary = data[4];
                Company company = new Company(companyName, departmentName, salary);

                personMap.putIfAbsent(name, person);
                personMap.get(name).setCompany(company);

            } else if (object.equals("pokemon")) {
                String pokemonName = data[2];
                String pokemonType = data[3];
                Pokemon pokemon = new Pokemon(pokemonName, pokemonType);

                personMap.putIfAbsent(name, person);
                personMap.get(name).addPokemon(pokemon);

            } else if (object.equals("parents")) {
                String parentName = data[2];
                String parentBirthDay = data[3];
                Parents parents = new Parents(parentName, parentBirthDay);

                personMap.putIfAbsent(name, person);
                personMap.get(name).addParent(parents);

            } else if (object.equals("children")) {
                String childrenName = data[2];
                String childrenBirthDay = data[3];
                Children children = new Children(childrenName, childrenBirthDay);

                personMap.putIfAbsent(name, person);
                personMap.get(name).addChildren(children);

            } else if (object.equals("car")) {
                String carModel = data[2];
                String carSpeed = data[3];
                Car car = new Car(carModel, carSpeed);

                personMap.putIfAbsent(name, person);
                personMap.get(name).setCar(car);
            }

        }

        String name = scanner.nextLine();

        for (Map.Entry<String, Person> personEntry : personMap.entrySet()) {
            if (personEntry.getKey().equals(name)) {
                System.out.println(name);
                System.out.println("Company:");
                if (personEntry.getValue().getCompany() != null) {
                    System.out.println(String.format("%s %s %s"
                            , personEntry.getValue().getCompany().getCompanyName()
                            , personEntry.getValue().getCompany().getDepartmnent()
                            , personEntry.getValue().getCompany().getSalary()));
                }
                System.out.println("Car:");
                if (personEntry.getValue().getCar() != null) {
                    System.out.println(String.format("%s %s"
                            , personEntry.getValue().getCar().getCarModel()
                            , personEntry.getValue().getCar().getCarSpeed()));
                }
                System.out.println("Pokemon:");
                if (personEntry.getValue().getPokemonListSize() > 0) {
                    for (Pokemon pokemon : personEntry.getValue().getPokemonsFromTheList()) {
                        System.out.println(String.format("%s %s", pokemon.getPokemonName(), pokemon.getPokeminType()));
                    }
                }
                System.out.println("Parents:");
                if (personEntry.getValue().getParentsListSize() > 0) {
                    for (Parents parents : personEntry.getValue().getParentsFromTheList()) {
                        System.out.println(String.format("%s %s", parents.getParentName(), parents.getParentBirthDay()));
                    }
                }
                System.out.println("Children:");
                if (personEntry.getValue().getChildrenListSize() > 0) {
                    for (Children children : personEntry.getValue().getChildrenFromTheList()) {
                        System.out.println(String.format("%s %s", children.getChildrenName(), children.getChildrenBirthDay()));
                    }
                }
            }
        }


    }
}
