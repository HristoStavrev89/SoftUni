package animals;

public class Dog extends Animal {
    private final static String DJAAF = "DJAAF";


    protected Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        String explain = String.format("%s %n%s",
                super.baseExplain()
                ,DJAAF);
        return explain;
    }
}
