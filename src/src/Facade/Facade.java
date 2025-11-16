package Facade;

import FactoryMenu.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Facade {

    private final Scanner choice = new Scanner(System.in);

    private final UserService userService = new UserService();

    private List<Dish> orderedDishes = new ArrayList<>();
    private int totalPrice = 0;

    private boolean running = true;


    public void mainMenu() {

        while (running) {

            if (!userService.isLoggedIn()) {
                System.out.println("\nYou must log in or register.");
                System.out.println("1.Register\n2.Login");
                System.out.print("Choose: ");

                switch (choice.nextInt()) {
                    case 1:
                        userService.register();
                        break;
                    case 2:
                        userService.login();
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }

            System.out.println("=== Pick Me Restaurant ===");
            System.out.println("1. Show menu");
            System.out.println("2. Order dishes");
            System.out.println("3. Show ordered dishes");
            System.out.println("4. Pay order");
            System.out.println("5. Log out");
            System.out.println("6. Add new user");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            switch (choice.nextInt()) {
                case 1:
                    MenuService menu = new MenuService();
                    menu.showMenu();
                    break;
                case 2:
                    Order();
                    break;
                case 3:
                    ShowOrderService showOrderService = new ShowOrderService();
                    showOrderService.showOrderedDishes(orderedDishes, totalPrice);
                    break;
                case 4:
                    PaymentService paymentService = new PaymentService();
                    paymentService.payOrder(totalPrice);
                    break;
                case 5:
                    userService.logout();
                    break;
                case 6:
                    userService.addNewUser();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private void Order() {
        OrderService orderService = new OrderService();
        orderService.orderDishes();

        totalPrice = orderService.getTotalPrice();
        orderedDishes=orderService.getOrderDishes();

    }
}
