package Facade;

import Builder.*;
import Strategy.*;

import java.util.Scanner;

public class PaymentService {
    private final PaymentContext cardPayment = new PaymentContext(new CardPayment());
    private final PaymentContext cashPayment = new PaymentContext(new CashPayment());
    private final PaymentContext qrPayment = new PaymentContext(new QRPayment());
    private final Scanner scanner = new Scanner(System.in);

    public void payOrder(int totalPrice) {
        PaymentOrderBuilder builder = new PaymentOrderBuilder()
                .setOriginalPrice(totalPrice);

        System.out.println("\nDo you want to play a mini-game for a 10% discount?");
        System.out.println("1.Yes  2.No");
        int playChoice = scanner.nextInt();

        MiniGame game = new MiniGame();
        if (playChoice == 1) {
            boolean win = game.play();
            if (win) builder.applyDiscount();
        }

        PaymentOrder order = builder.build();

        System.out.println("\n--- Payment Summary ---");
        System.out.println("Original Price: " + order.getOriginalPrice());
        System.out.println("Final Price: " + order.getFinalPrice());
        System.out.println("------------------------\n");

        System.out.println("Choose payment method:");
        System.out.println("1.Card\n2.Cash\n3.Qr\nChoose:");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                cardPayment.executeStrategy(order.getFinalPrice());
                break;
            case 2:
                cashPayment.executeStrategy(order.getFinalPrice());
                break;
            case 3:
                qrPayment.executeStrategy(order.getFinalPrice());
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
}