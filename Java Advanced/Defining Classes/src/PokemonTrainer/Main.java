package PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        Map<String, Trainer> tournament = new LinkedHashMap<>();

        while (!"Tournament".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");

            String trainerName = data[0];
            String pokemonname = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            Pokemon pokemon = new Pokemon(pokemonname, pokemonElement, pokemonHealth);

            tournament.putIfAbsent(trainerName, new Trainer());
            tournament.get(trainerName).addPokemon(pokemon);


        }

        String data = "";

        while (!"End".equals(data = scanner.nextLine())) {
            String element = data;

            for (Map.Entry<String, Trainer> kvp : tournament.entrySet()) {
                if (kvp.getValue().getPokemonCollectionSize() > 0) {
                    boolean havePokemon = false;

                    for (Pokemon pokemon : kvp.getValue().getPokemons()) {
                        if (pokemon.getElement().equals(element)) {
                            havePokemon = true;
                            kvp.getValue().setBadges();
                            break;
                        }
                    }
                    if (!havePokemon) {
                        kvp.getValue().pokemonPenalty();
                    }
                }
            }
        }


        tournament.entrySet().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getValue().getBadges(), t1.getValue().getBadges()))
                .forEach(trainer -> System.out.println(String.format("%s %d %d",trainer.getKey()
                ,trainer.getValue().getBadges(), trainer.getValue().getPokemonCollectionSize())));

    }
}
