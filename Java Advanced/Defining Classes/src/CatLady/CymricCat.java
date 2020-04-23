package CatLady;
public class CymricCat extends Cat{

    public CymricCat(String name, double skillValue) {
        super(name, skillValue);
    }

    @Override
    public String toString() {
        return "Cymric" + super.toString();
    }
}
