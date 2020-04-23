package solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;

import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

public class Square implements Shape {


    public Square() {

    }

    @Override
    public void draw() {
        System.out.println("Square?!");
    }
}
