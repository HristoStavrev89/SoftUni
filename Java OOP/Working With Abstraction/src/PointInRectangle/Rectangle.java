package PointInRectangle;

public class Rectangle {

    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topLeft) {
        this.bottomLeft = bottomLeft;
        this.topRight = topLeft;
    }

    public boolean contains(Point point) {

        boolean checkX = point.getCoordinateX() >= this.bottomLeft.getCoordinateX() &&
                point.getCoordinateX() <= this.topRight.getCoordinateX();

        boolean checkY = point.getCoordinateY() >= this.bottomLeft.getCoordinateY() &&
                point.getCoordinateY() <= this.topRight.getCoordinateY();


        return checkX && checkY;
    }

}
