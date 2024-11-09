package Onlines.Practice;

class FlightBookingSystem {
    public void bookFlight() {
        System.out.println("Flight booked");
    }

    public void cancelFlight() {
        System.out.println("Flight booking canceled");
    }
}

class HotelBookingSystem {
    public void bookHotel() {
        System.out.println("Hotel booked");
    }

    public void cancelHotel() {
        System.out.println("Hotel booking canceled");
    }
}

class CarRentalSystem {
    public void bookCar() {
        System.out.println("Car rented");
    }

    public void cancelCar() {
        System.out.println("Car rental canceled");
    }
}

class TravelBookingFacade {
    private FlightBookingSystem flightBookingSystem;
    private HotelBookingSystem hotelBookingSystem;
    private CarRentalSystem carRentalSystem;

    public TravelBookingFacade(FlightBookingSystem flightBookingSystem, HotelBookingSystem hotelBookingSystem,
            CarRentalSystem carRentalSystem) {
        this.flightBookingSystem = flightBookingSystem;
        this.hotelBookingSystem = hotelBookingSystem;
        this.carRentalSystem = carRentalSystem;
    }

    public void bookCompletePackage() {
        System.out.println("Booking...");
        flightBookingSystem.bookFlight();
        hotelBookingSystem.bookHotel();
        carRentalSystem.bookCar();
        System.out.println("...Booked");
    }

    public void cancelPackage() {
        System.out.println("Cancelling...");
        flightBookingSystem.cancelFlight();
        hotelBookingSystem.cancelHotel();
        carRentalSystem.cancelCar();
        System.out.println("...Cancelled");
    }

}

public class TravelBookingTest {
    public static void main(String[] args) {
        FlightBookingSystem flightBookingSystem = new FlightBookingSystem();
        HotelBookingSystem hotelBookingSystem = new HotelBookingSystem();
        CarRentalSystem carRentalSystem = new CarRentalSystem();

        TravelBookingFacade travelBookingFacade = new TravelBookingFacade(flightBookingSystem, hotelBookingSystem,
                carRentalSystem);

        travelBookingFacade.bookCompletePackage();

        travelBookingFacade.cancelPackage();
    }
}
