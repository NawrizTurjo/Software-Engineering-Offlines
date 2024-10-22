package Producer;

import Interfaces.Vehicle;
import Products.*;

public class RideSelect {
    public static Vehicle getVehicle(String userInput)
    {
        if(userInput == null || userInput.isEmpty())
        {
            return null;
        }
        else
        {
            if(userInput.equalsIgnoreCase("SEDAN"))
            {
                return new Sedan();
            }
            else if(userInput.equalsIgnoreCase("SUV"))
            {
                return new SUV();
            }
            else if(userInput.equalsIgnoreCase("MOTORBIKE"))
            {
                return new Motorbike();
            }
            else
            {
                return null;
            }
        }
    }
}
