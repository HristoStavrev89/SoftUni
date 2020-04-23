package animals;

public class Cat extends Animal {
    private final static String MEEOW = "MEEOW";


    protected Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        String explain = String.format("%s %n%s",
                super.baseExplain()
        ,MEEOW);
        return explain;
    }
}
