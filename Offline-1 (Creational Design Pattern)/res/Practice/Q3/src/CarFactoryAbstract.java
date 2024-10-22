import java.util.Scanner;

interface HondaFactory
{
    void createEngine();
    void createTrans();
}

class CivicFactory implements HondaFactory
{
    public void createEngine()
    {
        System.out.println("Creating Civic Engine");
    }
    public void createTrans()
    {
        System.out.println("Creating Civic Transmission");
    }
}

class AccordFactory implements HondaFactory
{
    public void createEngine()
    {
        System.out.println("Creating Accord Engine");
    }
    public void createTrans()
    {
        System.out.println("Creating Accord Transmission");
    }
}

class Producer
{
    public static HondaFactory getFactory(String model)
    {
        if(model.equalsIgnoreCase("Civic"))
        {
            return new CivicFactory();
        }
        else if(model.equalsIgnoreCase("Accord"))
        {
            return new AccordFactory();
        }
        return null;
    }
}



public class CarFactoryAbstract {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the model of the car: ");
        String model = sc.nextLine();
        HondaFactory hondaFactory = Producer.getFactory(model);
        hondaFactory.createEngine();
        hondaFactory.createTrans();
        sc.close();
    }
}
