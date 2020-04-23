package PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Trainer {
    private int badges;
    private List<Pokemon> pokemons;


    public Trainer () {
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon (Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public List<Pokemon> getPokemons() {
        return new ArrayList<>(this.pokemons);
    }

    public int getPokemonCollectionSize () {
        return this.pokemons.size();
    }

    public void setBadges() {
        this.badges = badges + 1;
    }

    public int getBadges() {
        return badges;
    }

    private UnaryOperator<Pokemon> damagePokemon = pokemon ->
            new Pokemon(pokemon.getName(), pokemon.getElement(), pokemon.getHealth() - 10);

    public void pokemonPenalty() {
        this.pokemons = this.pokemons
                .stream()
                .map(damagePokemon)
                .filter(pokemon -> pokemon.getHealth() > 0)
                .collect(Collectors.toList());

    }

}
