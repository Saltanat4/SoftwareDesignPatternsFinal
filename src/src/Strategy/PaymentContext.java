package Strategy;

public class PaymentContext {
    private PaymentStrategy strategy;
    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy(int amount) {
        if (strategy != null) {
            strategy.pay(amount);
        } else {
            System.out.println("Payment failed");
        }
    }
}
