package TicketingConcrete;

import Interfaces.Ticketing;

public class NFC implements Ticketing {

    @Override
    public void addTicketing() {
        System.out.println("NFC ticketing added");
    }

}
