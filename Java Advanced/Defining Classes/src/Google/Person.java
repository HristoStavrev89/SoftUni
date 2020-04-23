package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private Car car;
    private List<Parents> parentsList;
    private List<Children> childrenList;
    private List<Pokemon> pokemonList;



    public Person () {
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.pokemonList = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public void addPokemon (Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public void addParent (Parents parent) {
        this.parentsList.add(parent);
    }

    public void addChildren (Children children) {
        this.childrenList.add(children);
    }
    public void setCar (Car car) {
        this.car = car;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public int getPokemonListSize () {
        return pokemonList.size();
    }

    public List<Pokemon> getPokemonsFromTheList () {
        return new ArrayList<>(this.pokemonList);
    }

    public int getChildrenListSize () {
        return childrenList.size();
    }

    public List<Children> getChildrenFromTheList () {
        return new ArrayList<>(this.childrenList);
    }

    public int getParentsListSize () {
        return parentsList.size();
    }

    public List<Parents> getParentsFromTheList () {
        return new ArrayList<>(this.parentsList);
    }

}
