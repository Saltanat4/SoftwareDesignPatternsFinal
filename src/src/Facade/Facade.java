package Facade;

import FactoryMenu.*;
import FactoryMenu.Dishes.Drinks.DrinkCreator;
import FactoryMenu.Dishes.Drinks.*;
import FactoryMenu.Dishes.KazakhCuisine.*;
import FactoryMenu.Dishes.ItalianCuisine.*;
import FactoryMenu.Dishes.KoreanCuisine.*;
import Observer.*;
import Strategy.*;
import Decorator.*;
import Builder.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Facade{
    private final List<Dish> orderDishes=new ArrayList<>();
    private final List<Dish> orderDrinks=new ArrayList<>();
    private final KazakhDish kazakhDishes=new KazakhDish();
    private final ItalianDish italianDishes=new ItalianDish();
    private final KoreanDish koreanDishes=new KoreanDish();
    private final DrinkCreator drinks=new DrinkCreator();
    private final PaymentContext cardPayment=new PaymentContext(new CardPayment());
    private final PaymentContext cashPayment=new PaymentContext(new CashPayment());
    private final PaymentContext qrPayment=new PaymentContext(new QRPayment());
    private final Order.OrderBuilder orderBuilder = new Order.OrderBuilder();
    private Dish dish;

    private final Subject subject=new Beshbarmak();
    userObserver userObserver=new userObserver();
    orderObserver orderObserver =new orderObserver();
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
                System.out.println("4.Pay orderObserver");
                System.out.println("5.Log out");
                System.out.println("6.Add new user");
                System.out.println("0.Exit");
                System.out.println("Select an option:");
                switch (choice.nextInt()) {
                    case 1:
                        showMenu();
                        break;
                    case 2:
                        orderDishes();
                        break;
                    case 3:
                        showOrderedDishes();
                        break;
                    case 4:
                        payOrder();
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
    public void showMenu(){
        System.out.println("===Kazakh cuisine===");
        kazakhDishes.setKazakhDish();
        kazakhDishes.displayDishes();
        System.out.println("===Italian cuisine===");
        italianDishes.setDishes();
        italianDishes.displayDishes();
        System.out.println("===Korean cuisine===");
        koreanDishes.setDishes();
        koreanDishes.displayDishes();
        System.out.println("===Drinks===");
        drinks.setDishes();
        drinks.displayDishes();
    }

    public void orderDishes(){
        System.out.println("===Choose Dishes===");
        System.out.println("1.Kazakh Cuisine\n2.Italian Cuisine\n3.Korean Cuisine\n0.Exit\nChoose:");
        int cuisine=choice.nextInt();
        switch(cuisine) {
            case 1:
                kazakhMenu();
                break;
            case 2:
                italianMenu();
                break;
            case 3:
                koreanMenu();
                break;
            case 4:
                orderDrinks();
                break;
            case 0:
                mainMenu();
            default:
                System.out.println("Invalid choice");
        }
    }

    public void kazakhMenu() {
        System.out.println("===Choose Dishes===");
        System.out.println("1.Beshbarmak\n2.Mantas\n3.Quyrdak\nChoose:");
        int dishChoice = choice.nextInt();
        switch (dishChoice) {
            case 1:
                processDish(new Beshbarmak());
                break;
            case 2:
                processDish(new Mantas());
                break;
            case 3:
                processDish(new Quyrdaq());
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public void italianMenu(){
        System.out.println("===Choose Dishes===");
        System.out.println("1.Lasagna\n2.Pasta\n3.Risotto\nChoose:");
        int dishChoice=choice.nextInt();
        switch(dishChoice) {
            case 1:
                processDish(new Lasagna());
                break;
            case 2:
                processDish(new Pasta());
                break;
            case 3:
                processDish(new Risotto());
               break;
            default:
                System.out.println("Invalid choice");
        }

    }
    public void koreanMenu(){
        System.out.println("===Choose Dishes===");
        System.out.println("1.Ramen\n2.Sushi\n3.Tteokpokki\nChoose:");
        int dishChoice=choice.nextInt();
        switch(dishChoice) {
            case 1:
                processDish(new Ramen());
                break;
            case 2:
                processDish(new Sushi());
                break;
            case 3:
                processDish(new Tteokpokki());
                break;
            default:
                System.out.println("Invalid choice");
        }

    }

    public void orderDrinks(){
        System.out.println("===Choose Drinks===");
        System.out.println("1.Water\n2.Juice\n3.Lemonade\nChoose:");
        int drinkChoice=choice.nextInt();
        switch(drinkChoice) {
            case 1:
                processDish(new Water());
                break;
            case 2:
                processDish(new Juice());
                break;
            case 3:
                processDish(new Lemonade());
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
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
            case 1->cardPayment.executeStrategy(total);
            case 2->cashPayment.executeStrategy(total);
            case 3->qrPayment.executeStrategy(total);
            default->System.out.println("Invalid choice");
        }
    }

    public void showOrderedDishes(){
        for (Dish orderDish : orderDishes) {
            System.out.println(orderDish.dishName() + " " + orderDish.getDishPrice());
        }
        for (Dish orderDrink : orderDrinks) {
            System.out.println(orderDrink.dishName() + " " + orderDrink.getDishPrice());
        }
        System.out.println("Total Price: " + totalPrice);
    }

    private void processDish(Dish newDish) {
        dish = newDish;
        subject.addObserver(orderObserver);
        totalPrice += dish.getDishPrice();
        subject.setMessage("You ordered " + dish.dishName() + ". Bon appetit!");
        subject.setMessage("Please wait 55-65 minutes for the order to arrive.");
        subject.removeObserver(orderObserver);
        userChoice();

        //он нужен чтобы в payOrder
        // метод builder мог найти заказанную еду!!!
        orderBuilder.addDish(dish);
        orderDishes.add(dish);
        orderDishes();
    }

    public void userChoice(){
        System.out.println("Do you want add extras?\n1.Yes\n2.No\nChoose:");
        int addExtras=choice.nextInt();
        switch(addExtras) {
            case 1:
                addExtras();
                break;
            case 2:
                break;
        }
    }

    public void addExtras(){
        System.out.println("===Choose Extras===");
        System.out.println("1.Bread\n2.Salad\n3.Sauce\nChoose:");
        int extrasChoice=choice.nextInt();
        switch(extrasChoice) {
            case 1:
                dish= new BreadDecorator(dish);
                break;
            case 2:
                dish = new SaladDecorator(dish);
                break;
            case 3:
                dish = new SauceDecorator(dish);
                break;
            default:
                System.out.println("Invalid choice");
        }
        totalPrice += dish.getDishPrice();
        subject.addObserver(orderObserver);
        subject.setMessage("You added extra " + dish.dishName() + ".");
        subject.removeObserver(orderObserver);
    }
}



