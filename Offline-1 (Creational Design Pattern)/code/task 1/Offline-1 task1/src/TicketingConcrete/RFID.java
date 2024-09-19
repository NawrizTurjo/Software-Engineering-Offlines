package TicketingConcrete;

import Interfaces.Ticketing;

public class RFID implements Ticketing{

    @Override
    public void addTicketing() {
        System.out.println("RFID ticketing added");
    }

    public String toString() {
        return "RFID Ticketing";
    }

}
