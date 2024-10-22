// Abstract Product
interface Shape
{
    void draw();
}

// Concrete Product
class Rectangle implements Shape
{
    @Override
    public void draw()
    {
        System.out.println("Drawing Rectangle");
    }
}

class Circle implements Shape
{
    @Override
    public void draw()
    {
        System.out.println("Drawing Circle");
    }
}

class RoundedRectangle implements Shape
{
    @Override
    public void draw()
    {
        System.out.println("Drawing RoundedRectangle");
    }
}

class RoundedSquare implements Shape
{
    @Override
    public void draw()
    {
        System.out.println("Drawing RoundedSquare");
    }
}

// Abstract Factory
abstract class AbstractFactory
{
    abstract Shape getShape(String shapeType);
}

// Concrete Factory
class ShapeFactory extends AbstractFactory
{
    public Shape getShape(String shapeType)
    {
        if(shapeType.equalsIgnoreCase("Rectangle"))
        {
            return new Rectangle();
        }
        else if(shapeType.equalsIgnoreCase("Circle"))
        {
            return new Circle();
        }
        return null;
    }
}

class RoundedShapeFactory extends AbstractFactory
{
    @Override
    Shape getShape(String shapeType)
    {
        if(shapeType.equalsIgnoreCase("Rectangle"))
        {
            return new RoundedRectangle();
        }
        else if(shapeType.equalsIgnoreCase("Square"))
        {
            return new RoundedSquare();
        }
        return null;
    }
}

// Producer
class ShapeProducer
{
    public static AbstractFactory getFactory(boolean rounded)
    {
        if(rounded)
        {
            return new RoundedShapeFactory();
        }
        else
        {
            return new ShapeFactory();
        }
    }
}

// Client
public class shape2 {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = ShapeProducer.getFactory(false);
        Shape shape1 = shapeFactory.getShape("Rectangle");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("Circle");
        shape2.draw();

        AbstractFactory roundedShapeFactory = ShapeProducer.getFactory(true);
        Shape shape3 = roundedShapeFactory.getShape("Rectangle");
        shape3.draw();

        Shape shape4 = roundedShapeFactory.getShape("Square");
        shape4.draw();
    }
}
