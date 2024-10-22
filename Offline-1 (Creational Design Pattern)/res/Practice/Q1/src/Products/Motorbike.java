package Products;

import Interfaces.Vehicle;

public class Motorbike implements Vehicle {

    @Override
    public void booking() {
        System.out.println("Motorbike booked");
    }

}
