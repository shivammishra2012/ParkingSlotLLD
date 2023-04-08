package parkinglotApis;

import data.CardDetails;
import data.PaymentMode;
import data.Ticket;
import payments.ParkingFeeProcessor;
import payments.PaymentProcessor;
import payments.PaymentProcessorFactory;

import java.util.Map;


public class PayParkingFeesApi {

    public boolean payParkingFee(Ticket ticket, PaymentMode paymentMode, Map<String,String> paymentDetails)
    {
        PaymentProcessor paymentProcessor=null;
        if(paymentMode.equals(PaymentMode.CARD))
        {
            double amount= Double.parseDouble(paymentDetails.get("Amount"));
            CardDetails cardDetails=null;
            // logic to create carddetails project
            paymentProcessor= PaymentProcessorFactory.getCardBasedPaymentProcessor(amount,cardDetails);


        }
        else if(paymentMode.equals(PaymentMode.UPI))
        {
            double amount= Double.parseDouble(paymentDetails.get("Amount"));
            CardDetails cardDetails=null;
            // logic to create carddetails project
            paymentProcessor= PaymentProcessorFactory.getUpiBasedPaymentProcessor(amount,cardDetails);
        }
        else {
            throw new IllegalArgumentException();
        }

        return new ParkingFeeProcessor().processParkingFees(ticket,paymentProcessor);
    }
}
