package Facade;

import FactoryMenu.*;
import FactoryMenu.Dishes.KazakhCuisine.*;
import FactoryMenu.Dishes.ItalianCuisine.*;
import FactoryMenu.Dishes.KoreanCuisine.*;
import FactoryMenu.Drinks.*;
import Observer.*;
import Strategy.*;
import Decorator.*;

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
    private Dish dish;

    private final ArrayList<Dish> dishes=new ArrayList<>();

    orderObserver order =new orderObserver();
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
                System.out.println("3.Order drinks");
                System.out.println("4.Show ordered dishes");
                System.out.println("5.Pay order");
                System.out.println("6.Log out");
                System.out.println("7.Add new user");
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
                        orderDrinks();
                        break;
                    case 4:
                        showOrderedDishes();
                        break;
                    case 5:
                        payOrder();
                        break;
                    case 6:
                        logOut();
                        break;
                    case 7:
                        userManager.register();
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
                System.out.println("You are not logged in!");
                userManager.login();
                loggedOut=false;
                loggedIn=true;
            }
            else{
                System.out.println("\nHello! First, you need to log into the system!");
                userManager.register();
                loggedIn=true;
            }
        }
    }

    public void logOut() {
        loggedOut=true;
        loggedIn=false;
        System.out.println("You are logged out. Goodbye!\n");
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
        System.out.println("1.Kazakh Cuisine\n2.ItalianSubject Cuisine\n3.Korean Cuisine\n0.Exit\nChoose:");
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
            case 0:
                mainMenu();
            default:
                System.out.println("Invalid choice");
        }
    }

    public void kazakhMenu(){
        System.out.println("===Choose Dishes===");
        System.out.println("1.Beshbarmak\n2.Mantas\n3.Quyrdak\nChoose:");
        int dishChoice=choice.nextInt();
        switch(dishChoice) {
            case 1:
                processDish(new Beshbarmak());
                dish.addObserver(order);
                dish.setMessage("Please wait 1 hour for the order to arrive.");
                 break;
            case 2:
                processDish(new Mantas());
                dish.addObserver(order);
                dish.setMessage("Please wait 55 minutes for the order to arrive.");
                break;
            case 3:
                processDish(new Quyrdaq());
                dish.addObserver(order);
                dish.setMessage("Please wait 40 minutes for the order to arrive.");
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
                processDrinks(new Water());
                break;
            case 2:
                processDrinks(new Juice());
                break;
            case 3:
                processDrinks(new Lemonade());
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void payOrder(){
        System.out.println("Choose how to pay order:");
        System.out.println("1.Card\n2.Cash\n3.Qr\nChoose:");
        int orderChoice=choice.nextInt();
        switch(orderChoice) {
            case 1:
                cardPayment.executeStrategy(totalPrice);
                break;
            case 2:
                cashPayment.executeStrategy(totalPrice);
                break;
            case 3:
                qrPayment.executeStrategy(totalPrice);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void showOrderedDishes(){
        for (Dish orderDish : orderDishes) {
            System.out.println(orderDish.dishName() + " " + orderDish.getDishPrice());
        }
        for (Dish orderDrinks : orderDishes) {
            System.out.println(orderDrinks.dishName() + " " + orderDrinks.getDishPrice());
        }
        System.out.println("Total Price: " + totalPrice);
    }

    private void processDish(Dish newDish) {
        dish = newDish;
        dish.addObserver(order);
        totalPrice += dish.getDishPrice();
        dish.setMessage("You ordered " + dish.dishName() + ". Bon appetit!");
        dish.setMessage("Please wait 55-65 minutes for the order to arrive.");
        userChoice();
        orderDishes.add(dish);
        orderDishes();
    }

    private void processDrinks(Dish newDrink) {
        dish = newDrink;
        dish.addObserver(order);
        totalPrice += dish.getDishPrice();
        dish.setMessage("You ordered " + dish.dishName() + ".");
        dish.setMessage("Please wait 10-15 minutes for the order to arrive.");
        orderDrinks.add(dish);
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
                totalPrice += dish.getDishPrice();
                break;
            case 2:
                dish = new SaladDecorator(dish);
                totalPrice += dish.getDishPrice();
                break;
            case 3:
                dish = new SauceDecorator(dish);
                totalPrice += dish.getDishPrice();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}



