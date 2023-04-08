package payments;

public class UpiPaymentProcessor implements PaymentProcessor{

    private final double Amount;

    public UpiPaymentProcessor(double amount) {
        Amount = amount;
    }

    @Override
    public boolean executePayment() {
        return false;
    }

    @Override
    public Double getAmount() {
        return null;
    }
}
