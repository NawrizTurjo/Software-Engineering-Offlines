package Products;

import Interfaces.Vehicle;

public class SUV implements Vehicle {

    @Override
    public void booking() {
        System.out.println("SUV booked");
    }

}
