package Box;

public class Box {
    private double length;
    private double width;
    private double height;


    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private double getLength() {
        return this.length;
    }

    private double getWidth() {
        return this.width;
    }

    private double getHeight() {
        return this.height;
    }

    private void setLength(double length) {
        validateValue(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        validateValue(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        validateValue(height, "Height");
        this.height = height;
    }

    private void validateValue(double value, String dimension) {
        if (value <= 0) {
            throw new IllegalArgumentException(dimension + " cannot be zero or negative.");
        }
    }

    public double calculateVolume() {
        return this.getHeight() * this.getWidth() * this.getLength();
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.getLength() * this.getHeight() + 2 * this.getWidth() * this.getHeight();
    }

    public double calculateSurfaceArea() {
        return 2 * this.getLength() * this.getWidth() + 2 * this.getLength() * this.getHeight() + 2 * this.getWidth() * this.getHeight();
    }



//    @Override
//    public String toString() {
//        return String.format("Surface area - %.2f\n" +
//                        "Lateral surface area - %.2f\n" +
//                        "Volume - %.2f"
//                , this.surfaceArea()
//                , this.lateralSurfaceArea()
//                , this.calculateVolume());
//    }
}