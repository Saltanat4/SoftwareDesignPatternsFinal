package Strategy;

import Observer.Payment;

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(int amount){
        System.out.println("Paid " + amount + " tenge in cash. Thank you!");
    }
}
