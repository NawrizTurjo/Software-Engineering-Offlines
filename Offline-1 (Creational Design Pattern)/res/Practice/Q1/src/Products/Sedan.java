package Products;

import Interfaces.Vehicle;

public class Sedan implements Vehicle{

    @Override
    public void booking() {
        System.out.println("Sedan booked");
    }

    
}
