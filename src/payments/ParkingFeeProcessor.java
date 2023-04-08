package payments;

import data.Ticket;
import manager.VehicleTypeManager;
import manager.VehicleTypeManagerFactory;

public class ParkingFeeProcessor {
    public static  double getParkingFees(Ticket ticket)
    {
        double duartion=0;
        // figure out the duration

        return VehicleTypeManagerFactory.getVehicleTypeManager(ticket.getVehicle().getEntryTime()).getParkingFee(duartion);
    }
    //

    public boolean processParkingFees(Ticket ticket,PaymentProcessor paymentProcessor)
    {
        if(getParkingFees(ticket)!=paymentProcessor.getAmount())
        {
            throw new RuntimeException("");
        }
        return paymentProcessor.executePayment();
    }
}
