package Producer;

import Absfact.Modelsss;
import Factories.*;

public class FactoryProducer {
    public static Modelsss getModel(String model)
    {
        if(model.equalsIgnoreCase("WORKPRO"))
        {
            return new Workpro();
        }
        else if(model.equalsIgnoreCase("LITEMAX"))
        {
            return new LiteMax();
        }
        else
        {
            return null;
        }
    }
}
