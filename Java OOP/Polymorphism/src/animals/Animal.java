package animals;

public abstract class Animal {
    private String name;
    private String favouriteFood;


    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }


    public abstract String explainSelf();



    protected String baseExplain() {
        return String.format("I am %s my favourite food is %s"
        ,this.name
        ,this.favouriteFood);
    }

}
