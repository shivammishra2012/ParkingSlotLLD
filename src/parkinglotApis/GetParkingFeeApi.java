package parkinglotApis;

import data.Ticket;
import payments.ParkingFeeProcessor;

public class GetParkingFeeApi {

    public double getParkingFee(Ticket ticket)
    {
        return ParkingFeeProcessor.getParkingFees(ticket) ;
    }

}
