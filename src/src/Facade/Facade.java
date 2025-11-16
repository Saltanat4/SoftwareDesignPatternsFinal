package Facade;

import FactoryMenu.*;
import FactoryMenu.Dishes.KazakhCuisine.*;
import Observer.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Facade{
    private List<Dish> orderedDishes=new ArrayList<>();
    private final Subject subject=new Beshbarmak();
    userObserver userObserver=new userObserver();
    public String message;

    UserManager userManager=new UserManager();
    public boolean loggedIn=false;
    public boolean loggedOut=false;
    public boolean running=true;
    public int totalPrice=0;
    Scanner choice=new Scanner(System.in);

    public void mainMenu() {
        while (running) {
            if (loggedIn && !loggedOut) {
                System.out.println("===Pick Me Restaurant===");
                System.out.println("1.Show menu");
                System.out.println("2.Order dishes");
                System.out.println("3.Show ordered dishes");
                System.out.println("4.Pay order");
                System.out.println("5.Log out");
                System.out.println("6.Add new user");
                System.out.println("0.Exit");
                System.out.println("Select an option:");
                switch (choice.nextInt()) {
                    case 1:
                        MenuService menuService=new MenuService();
                        menuService.showMenu();
                        break;
                    case 2:
                        OrderService orderService=new OrderService();
                        orderService.orderDishes();
                        totalPrice=orderService.getTotalPrice();
                        orderedDishes=orderService.getOrderDishes();
                        break;
                    case 3:
                        ShowOrderService showOrderService=new ShowOrderService();
                        showOrderService.showOrderedDishes(orderedDishes, totalPrice);
                        break;
                    case 4:
                        PaymentService paymentService=new PaymentService();
                        paymentService.payOrder(totalPrice);
                        break;
                    case 5:
                        logOut();
                        break;
                    case 6:
                        userManager.register();
                        subject.addObserver(userObserver);
                        subject.setMessage("Added new user account!");
                        subject.removeObserver(userObserver);
                        mainMenu();
                    case 0:
                        running = false;
                        loggedOut=true;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
            else if(loggedOut) {
                userManager.login();
                loggedOut=false;
                loggedIn=true;
            }
            else{
                subject.addObserver(userObserver);
                subject.setMessage("Hello! First, you need to log into the system!");
                subject.removeObserver(userObserver);
                userManager.register();
                loggedIn=true;
            }
        }
    }

    public void logOut() {
        loggedOut=true;
        loggedIn=false;
        subject.addObserver(userObserver);
        subject.setMessage("You are logged out. Goodbye!");
        subject.removeObserver(userObserver);
    }
}