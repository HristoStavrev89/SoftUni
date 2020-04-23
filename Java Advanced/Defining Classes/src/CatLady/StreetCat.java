package CatLady;
public class StreetCat extends Cat{
    public StreetCat (String name, double decibelsOfMeows) {
        super(name, decibelsOfMeows);
    }

    @Override
    public String toString() {
        return "StreetExtraordinaire " + super.toString();
    }
}
