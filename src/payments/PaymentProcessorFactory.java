package payments;

import data.CardDetails;

public class PaymentProcessorFactory {

    private PaymentProcessorFactory(){}
    // stateless class
    public static PaymentProcessor getCardBasedPaymentProcessor(double amount, CardDetails cardDetails)
    {
        return new CardPaymentProcessor(amount, cardDetails);
    }
    public static PaymentProcessor getUpiBasedPaymentProcessor(double amount, CardDetails cardDetails)
    {
        return new UpiPaymentProcessor(amount);
    }
}
