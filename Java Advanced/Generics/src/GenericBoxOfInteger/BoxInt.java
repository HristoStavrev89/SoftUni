package GenericBoxOfInteger;

public class BoxInt <T> {
    private T element;



    public BoxInt (T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return this.element.getClass().getName() + ": " + this.element;
    }
}
