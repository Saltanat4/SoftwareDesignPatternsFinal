package Strategy;

public class QRPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " tenge via QR. Thank you!");
    }
}
