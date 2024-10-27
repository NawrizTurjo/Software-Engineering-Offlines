interface FacadeShape {
    void draw();
}

class FacadeRectangle implements FacadeShape {

    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}

class FacadeCircle implements FacadeShape {

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}

class FacadeSquare implements FacadeShape {

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}

class FacadeShapeMaker {
    private FacadeShape circle;
    private FacadeShape rectangle;
    private FacadeShape square;

    public FacadeShapeMaker() {
        circle = new FacadeCircle();
        rectangle = new FacadeRectangle();
        square = new FacadeRectangle();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

    public void drawSquare() {
        square.draw();
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        FacadeShapeMaker shapeMaker = new FacadeShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
