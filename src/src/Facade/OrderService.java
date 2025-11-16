package Facade;

import Builder.*;
import Decorator.*;
import FactoryMenu.*;
import FactoryMenu.Dishes.Drinks.*;
import FactoryMenu.Dishes.KazakhCuisine.*;
import FactoryMenu.Dishes.KoreanCuisine.*;
import FactoryMenu.Dishes.ItalianCuisine.*;
import Observer.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {

    private final Subject subject=new Lasagna();
    orderObserver orderObserver =new orderObserver();

    private final List<Dish> orderDishes=new ArrayList<>();
    private Dish dish;

    public int totalPrice=0;
    Scanner choice=new Scanner(System.in);

    public void orderDishes(){
        System.out.println("===Choose Dishes===");
        System.out.println("1.Kazakh Cuisine\n2.Italian Cuisine\n3.Korean Cuisine\n4.Drinks\n0.Exit\nChoose:");
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
                break;
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

    private void processDish(Dish newDish) {
        dish = newDish;
        orderDishes.add(dish);
        subject.addObserver(orderObserver);
        totalPrice += dish.getDishPrice();
        subject.setMessage("You ordered " + dish.dishName() + ". Bon appetit!");
        subject.setMessage("Please wait 55-65 minutes for the order to arrive.");
        subject.removeObserver(orderObserver);
        userChoice();
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
        totalPrice = totalPrice - orderDishes.get(orderDishes.size() - 1).getDishPrice() + dish.getDishPrice();
        orderDishes.set(orderDishes.size() - 1, dish);

        subject.addObserver(orderObserver);
        subject.setMessage("You added extra " + dish.dishName() + ".");
        subject.removeObserver(orderObserver);
    }
    public List<Dish> getOrderDishes() {
        return orderDishes;
    }
    public int getTotalPrice(){
        return totalPrice;
    }
}
