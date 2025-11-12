package Facade;

import FactoryMenu.Dishes.*;
import FactoryMenu.Dishes.Calculate;
import FactoryMenu.Dishes.Drinks.DrinkCreator;
import FactoryMenu.Dishes.KazakhCuisine.*;
import FactoryMenu.Dishes.ItalianCuisine.*;
import FactoryMenu.Dishes.KoreanCuisine.*;
import Builder.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class DishCreator {
    Dish myDish;
    int cuisineChoice;
    DishFactory kazakhDish=new KazakhDish();
    DishFactory italianDish=new ItalianDish();
    DishFactory koreanDish=new KoreanDish();
    DishFactory drinks=new DrinkCreator();
    List<Dish> dishes=new ArrayList<>();

    Calculate calculate=new Calculate();
    public void cuisineMenu() {
        boolean order=true;
        while(order) {
            System.out.println("Now you can order food and drinks.\n(for finish order '0')");
            System.out.println("What kind of cuisine would you like to try?" +
                    "\n1.Kazakh\n2.Italian\n3.Korean\n4.Drinks\nChoose:");
            cuisineChoice = (new Scanner(System.in)).nextInt();
            switch (cuisineChoice) {
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
                    drinkMenu();
                    break;
                case 0:
                    System.out.println("Thank for ordering!");
                    System.out.println(calculate.getOrderedDishes());
                    System.out.println("Total: "+totalCheck());
                    order=false;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    order=false;
                    break;
            }}
    }
    public List<Dish> setOrder() {
        return calculate.getOrderedDishes();
    }
    public int totalCheck(){
        int total=0;
        total= total+ calculate.getDish();
        return total;
    }
    public void kazakhMenu() {
        System.out.println("This is our Kazakh cuisine!:) " +
                "Please select from the menu what you want to order:");
        System.out.println( "1.Beshbarmak\n2.Mantas\n3.Kuyrdak");
        System.out.println("Choose:");
        int orderKazakhDish = new Scanner(System.in).nextInt();
        switch (orderKazakhDish) {
            case 1:
                myDish=kazakhDish.createDish(DishCategory.BESHBARMAK);
                calculate.addCalculate(kazakhDish.createDish(DishCategory.BESHBARMAK));
                break;
            case 2:
                myDish=kazakhDish.createDish(DishCategory.MANTAS);
                calculate.addCalculate(myDish);
                break;
            case 3:
                myDish= kazakhDish.createDish(DishCategory.QUYRDAQ);
                calculate.addCalculate(kazakhDish.createDish(DishCategory.QUYRDAQ));
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid choice.");
        }
        System.out.println(myDish+" is ordered!");
    }
    public void italianMenu() {
        System.out.println("This is Italian cuisine!" +
                "\nPlease select from the menu what you want to order:");
        System.out.println("1.Pasta\n2.Lazagna\n3.Risotto");
        System.out.println("Choose:");
        int orderItalianDish = new Scanner(System.in).nextInt();

        switch (orderItalianDish) {
            case 1:
                myDish=italianDish.createDish(DishCategory.PASTA);
                calculate.addCalculate(italianDish.createDish(DishCategory.PASTA));
                break;
            case 2:
                myDish=italianDish.createDish(DishCategory.LAZAGNA);
                calculate.addCalculate(italianDish.createDish(DishCategory.LAZAGNA));
                break;
            case 3:
                myDish=italianDish.createDish(DishCategory.RISOTTO);
                calculate.addCalculate(italianDish.createDish(DishCategory.RISOTTO));
                break;
            default:
                System.out.println("Invalid choice.");
        }
        System.out.println(myDish+ "is ordered");

    }

    public void koreanMenu() {
        System.out.println("This is Korean cuisine!" +
                "\nPlease select from the menu what you want to order:");
        System.out.println("1.Ramen\n2.Sushi\n3.Tokpokki");
        System.out.println("Choose:");
        int orderKoreanDish = new Scanner(System.in).nextInt();
        Dish total;
        switch (orderKoreanDish) {
            case 1:
                myDish= koreanDish.createDish(DishCategory.RAMEN);
                calculate.addCalculate(koreanDish.createDish(DishCategory.RAMEN));
                break;
            case 2:
                myDish= koreanDish.createDish(DishCategory.SUSHI);
                calculate.addCalculate(koreanDish.createDish(DishCategory.SUSHI));
                break;
            case 3:
                myDish=koreanDish.createDish(DishCategory.TTEOKPOKKI);
                calculate.addCalculate(kazakhDish.createDish(DishCategory.TTEOKPOKKI));
                break;
            default:
                System.out.println("Invalid choice.");
        }
        System.out.println(myDish+ " is ordered");
    }

    public void drinkMenu() {
        System.out.println("This is Drinks menu!"+
                "\nPlease select from the menu what you want to order:");
        System.out.println("1.Lemonade\n2.Juice\n3.Water");
        System.out.println("Choose:");
        int orderDrink = new Scanner(System.in).nextInt();
        switch (orderDrink) {
            case 1:
                myDish= drinks.createDish(DishCategory.LEMONADE);
                calculate.addCalculate(myDish);
                break;
            case 2:
                myDish= drinks.createDish(DishCategory.JUICE);
                calculate.addCalculate(myDish);
                break;
            case 3:
                myDish=drinks.createDish(DishCategory.WATER);
                calculate.addCalculate(myDish);
                break;
            default:
                System.out.println("Invalid choice.");
        }
        System.out.println(myDish+ " is ordered");
    }

    public Order buildOrder(String customerName,double discount) {
        Order.OrderBuilder builder = new Order.OrderBuilder();

        for (Dish dish : calculate.getDishes()) {
            builder.addSetDish(dish);
        }
        builder.setTotalPrice(totalCheck());
        builder.setCustomerName(customerName);
        builder.setDiscount(discount);

        return builder.build();
    }

}