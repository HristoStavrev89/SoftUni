package Google;

public class Pokemon {
    private String pokemonName;
    private String pokeminType;


    public Pokemon (String name, String type) {
        this.pokemonName = name;
        this.pokeminType = type;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokeminType() {
        return pokeminType;
    }
}
