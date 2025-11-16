package Facade;

import Builder.*;
import Strategy.*;

import java.util.Scanner;

public class PaymentService {
    private final PaymentContext cardPayment=new PaymentContext(new CardPayment());
    private final PaymentContext cashPayment=new PaymentContext(new CashPayment());
    private final PaymentContext qrPayment=new PaymentContext(new QRPayment());
    private final Order.OrderBuilder orderBuilder = new Order.OrderBuilder();

    Scanner choice=new Scanner(System.in);
    public void payOrder(){
        System.out.println("Do you want to play a mini game for 10% discount?");
        System.out.println("1.Yes\n2.No");
        int gameChoice = choice.nextInt();
        if (gameChoice == 1) {
            orderBuilder.addMiniGame(new MiniGame());
        }
        Order finalOrder = orderBuilder.build();
        int total = finalOrder.getTotalPrice();

        System.out.println("Choose how to pay order:");
        System.out.println("1.Card\n2.Cash\n3.Qr\nChoose:");
        int orderChoice=choice.nextInt();
        switch(orderChoice) {
            case 1:
                cardPayment.executeStrategy(total);
                break;
            case 2:
                cashPayment.executeStrategy(total);
                break;
            case 3:
                qrPayment.executeStrategy(total);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }


}
