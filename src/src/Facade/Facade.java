package Facade;

import Builder.*;
import Decorator.*;
import FactoryMenu.Dishes.*;
import FactoryMenu.Dishes.ItalianCuisine.*;
import FactoryMenu.Dishes.KazakhCuisine.*;
import FactoryMenu.Dishes.KoreanCuisine.*;
import FactoryMenu.Dishes.Drinks.*;
import Observer.*;
import Strategy.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Facade{
    private List<Dish> orderDishes=new ArrayList<>();
    private List<Dish> orderDrinks=new ArrayList();
    private KazakhDish kazakhDishes=new KazakhDish();
    private ItalianDish italianDishes=new ItalianDish();
    private KoreanDish koreanDishes=new KoreanDish();
    private DrinkCreator drinks=new DrinkCreator();
    private PaymentContext cardPayment=new PaymentContext(new CardPayment());
    private PaymentContext cashPayment=new PaymentContext(new CashPayment());
    private PaymentContext qrPayment=new PaymentContext(new QRPayment());

    public boolean running=true;
    public int totalPrice=0;
    Scanner choice=new Scanner(System.in);

    public void mainMenu(){
        while(running){
            System.out.println("===Pick Me Restaurant===");
            System.out.println("1.Show menu");
            System.out.println("2.Order dishes");
            System.out.println("3.Order drinks");
            System.out.println("4.Pay order");
            System.out.println("0.Exit");
            System.out.println("Select an option:");
            switch(choice.nextInt()) {
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
                    payOrder();
                    break;
                case 0:
                    running=false;
                    System.out.println("You are logged out. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
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
        System.out.println("1.Kazakh Cuisine\n2.Italian Cuisine\n3.Korean Cuisine\nChoose:");
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
                System.out.println("Invalid choice");
        }
    }

    public void kazakhMenu(){
        System.out.println("===Choose Dishes===");
        System.out.println("1.Beshbarmak\n2.Mantas\n3.Quyrdak\nChoose:");
        int dishChoice=choice.nextInt();
        switch(dishChoice) {
            case 1:
                Beshbarmak beshbarmak=new Beshbarmak();
                orderDishes.add(beshbarmak);
                totalPrice+=beshbarmak.getDishPrice();
                System.out.println("You ordered "+beshbarmak.dishName()+".Bon appetit!");
                break;
            case 2:
                Mantas mantas=new Mantas();
                orderDishes.add(mantas);
                totalPrice+=mantas.getDishPrice();
                System.out.println("You ordered "+mantas.dishName()+".Bon appetit!");
                break;
            case 3:
                Quyrdaq quyrdaq=new Quyrdaq();
                orderDishes.add(quyrdaq);
                totalPrice+=quyrdaq.getDishPrice();
                System.out.println("You ordered "+quyrdaq.dishName()+".Bon appetit!");
                break;
            case 4:
                System.out.println("Invalid choice");
        }
    }
    public void italianMenu(){
        System.out.println("===Choose Dishes===");
        System.out.println("1.Lasagna\n2.Pasta\n3.Risotto\nChoose:");
        int dishChoice=choice.nextInt();
        switch(dishChoice) {
            case 1:
                Lasagna lasagna=new Lasagna();
                orderDishes.add(lasagna);
                totalPrice+=lasagna.getDishPrice();
                System.out.println("You ordered "+lasagna.dishName()+".Bon appetit!");
                break;
            case 2:
                Pasta pasta=new Pasta();
                orderDishes.add(pasta);
                totalPrice+=pasta.getDishPrice();
                System.out.println("You ordered "+pasta.dishName()+".Bon appetit!");
                break;
            case 3:
                Risotto risotto=new Risotto();
                orderDishes.add(risotto);
                totalPrice+=risotto.getDishPrice();
                System.out.println("You ordered "+risotto.dishName()+".Bon appetit!");
                break;
            case 4:
                System.out.println("Invalid choice");
        }
    }
    public void koreanMenu(){
        System.out.println("===Choose Dishes===");
        System.out.println("1.Ramen\n2.Sushi\n3.Tteokpokki\nChoose:");
        int dishChoice=choice.nextInt();
        switch(dishChoice) {
            case 1:
                Ramen ramen=new Ramen();
                orderDishes.add(ramen);
                totalPrice+=ramen.getDishPrice();
                System.out.println("You ordered "+ramen.dishName()+".Bon appetit!");
                break;
            case 2:
                Tteokpokki teokpokki=new Tteokpokki();
                orderDishes.add(teokpokki);
                totalPrice+=teokpokki.getDishPrice();
                System.out.println("You ordered "+teokpokki.dishName()+".Bon appetit!");
                break;
            case 3:
                Sushi sushi=new Sushi();
                orderDishes.add(sushi);
                totalPrice+=sushi.getDishPrice();
                System.out.println("You ordered "+sushi.dishName()+".Bon appetit!");
                break;
            case 4:
                System.out.println("Invalid choice");
        }
    }

    public void orderDrinks(){
        System.out.println("===Choose Drinks===");
        System.out.println("1.Water\n2.Juice\n3.Lemonade\nChoose:");
        int drinkChoice=choice.nextInt();
        switch(drinkChoice) {
            case 1:
                Water water=new Water();
                orderDrinks.add(water);
                totalPrice+=water.getDishPrice();
                System.out.println("You ordered "+water.dishName()+".");
                break;
            case 2:
                Juice juice=new Juice();
                orderDrinks.add(juice);
                totalPrice+=juice.getDishPrice();
                System.out.println("You ordered "+juice.dishName()+".");
                break;
            case 3:
                Lemonade lemonade=new Lemonade();
                orderDrinks.add(lemonade);
                totalPrice+=lemonade.getDishPrice();
                System.out.println("You ordered "+lemonade.dishName()+".");
                break;
            case 4:
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
            case 4:
                System.out.println("Invalid choice");
        }
    }

}