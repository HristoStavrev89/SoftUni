package solidLab.p03_LiskovSubstitution.p01_Square;

public class Main {
    public static void main(String[] args) {

        Shape square = new Square(5);

        Shape rectangle = new Rectangle(2.5, 5.5);

        System.out.println(square.getArea());

        System.out.println(rectangle.getArea());

    }
}
