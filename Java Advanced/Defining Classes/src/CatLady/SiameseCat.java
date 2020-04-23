package CatLady;

public class SiameseCat extends Cat{
    public SiameseCat(String name, double earSize) {
        super(name, earSize);
    }

    @Override
    public String toString() {
        return "Siamese " + super.toString();
    }
}
