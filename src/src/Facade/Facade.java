package Facade;
import FactoryMenu.Builder.Order;
import FactoryMenu.Dishes.*;
import FactoryMenu.Dishes.Calculate;
import FactoryMenu.Dishes.KazakhCuisine.*;
import FactoryMenu.Dishes.ItalianCuisine.*;
import FactoryMenu.Dishes.KoreanCuisine.*;
import FactoryMenu.Drink.DrinkSet;
import FactoryMenu.ShowAllMenu;

import java.util.Scanner;

public class Facade {
    int cuisineChoice;
    boolean running=true;
    DishCreator kazakhDish=new KazakhDish();
    DishCreator italianDish=new ItalianDish();
    DishCreator koreanDish=new KoreanDish();
    DrinkSet drinks=new DrinkSet();
    ShowAllMenu showAllMenu=new ShowAllMenu();
    Calculate calculate=new Calculate();
    public void mainMenu() {
        while(running){
            System.out.println("=====PICK ME RESTAURANT=====" +
                    "\nWelcome to our restaurant!");
            System.out.println("1.Show all menu");
            System.out.println("2.Order dishes");
            System.out.println("3.Pay order");
            System.out.println("0.Exit");
            System.out.println("Choose your choice:");
            int mainMenuChoice = new Scanner(System.in).nextInt();
            switch (mainMenuChoice) {
                case 1:
                    showAllMenu.showMenu();
                    break;
                case 2:
                    boolean order=true;
                    while (order){
                    cuisineMenu();
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
                            int total=0;
                            total=total+calculate.getDish();
                            System.out.println("Total: "+total);
                            order=false;
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            order=false;
                            break;
                    }}
                    break;
                case 3:
                    makeOrder();
                    break;
                case 0:
                    running=false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

    }
    Dish myDish;
    public void makeOrder() {
        Order.OrderBuilder builder = new Order.OrderBuilder();

        builder.addDish(myDish);

        builder.setCustomerName("Aigerim");
        builder.setAddress("Almaty, Abay street 25");
        builder.setDiscount(0.10);

        Order order = builder.build();
        order.showOrder();
    }

    public void cuisineMenu() {
        System.out.println("Now you can order food and drinks.");
        System.out.println("What kind of cuisine would you like to try?" +
                "\n1.Kazakh\n2.Italian\n3.Korean\n4.Drinks\nChoose:");
        cuisineChoice = (new Scanner(System.in)).nextInt();
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
                calculate.getDish();
                break;
            case 2:
                myDish=kazakhDish.createDish(DishCategory.MANTAS);
                calculate.addCalculate(kazakhDish.createDish(DishCategory.MANTAS));
                calculate.getDish();
                break;
            case 3:
                myDish= kazakhDish.createDish(DishCategory.QUYRDAQ);
                calculate.addCalculate(kazakhDish.createDish(DishCategory.QUYRDAQ));
                calculate.getDish();
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
                calculate.getDish();
                break;
            case 2:
                myDish=italianDish.createDish(DishCategory.LAZAGNA);
                calculate.addCalculate(italianDish.createDish(DishCategory.LAZAGNA));
                calculate.getDish();
                break;
            case 3:
                myDish=italianDish.createDish(DishCategory.RISOTTO);
                calculate.addCalculate(italianDish.createDish(DishCategory.RISOTTO));
                calculate.getDish();
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
                calculate.getDish();
                break;
            case 2:
                myDish= koreanDish.createDish(DishCategory.SUSHI);
                calculate.addCalculate(koreanDish.createDish(DishCategory.SUSHI));
                calculate.getDish();
                break;
            case 3:
                myDish=koreanDish.createDish(DishCategory.TTEOKPOKKI);
                calculate.addCalculate(kazakhDish.createDish(DishCategory.TTEOKPOKKI));
                calculate.getDish();
                break;
            default:
                System.out.println("Invalid choice.");
        }
        System.out.println(myDish+ " is ordered");
    }
    public void drinkMenu() {
        System.out.println("This is Drinks menu!"+
                "\nPlease select from the menu what you want to order:");
        drinks.displayDrinks();
        int orderDrinkDish = new Scanner(System.in).nextInt();

                System.out.println(myDish+ " is ordered ");
        }
}
