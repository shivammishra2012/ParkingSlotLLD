package payments;

public interface PaymentProcessor {

    boolean executePayment();

    Double getAmount();
}
