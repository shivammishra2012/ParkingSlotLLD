package packageGenerator;

import data.ParkingSpot;
import data.Ticket;
import data.Vehicle;

public class TicketGenerator {

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot)
    {
       String ticketNum= getUniqueTicketNum();
       // write a logic to check this parkingspot is free and persist in db
        // acquiring lock we can save deadlock
        return new Ticket(ticketNum,vehicle,parkingSpot);
    }
    private String getUniqueTicketNum()
    {
        return "";
    }
}
