package Facade;

import FactoryMenu.Dishes.*;
import FactoryMenu.Dishes.Calculate;
import FactoryMenu.Dishes.KazakhCuisine.*;
import FactoryMenu.Dishes.ItalianCuisine.*;
import FactoryMenu.Dishes.KoreanCuisine.*;
import FactoryMenu.Drink.Drink;
import FactoryMenu.Drink.DrinkFactory;
import FactoryMenu.Drink.DrinkSet;
import FactoryMenu.Drink.*;
import FactoryMenu.ShowAllMenu;
import org.w3c.dom.ls.LSOutput;

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
                            System.out.println(total);
                            order=false;
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            order=false;
                            break;
                    }}
                    break;
                case 0:
                    running=false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

    }

    public void cuisineMenu() {
        System.out.println("What kind of cuisine would you like to try?" +
                "\n1.Kazakh\n2.Italian\n3.Korean\n4.Drinks\nChoose:");
        cuisineChoice = (new Scanner(System.in)).nextInt();
        System.out.println("Now you can order food and drinks.");
    }
    String myDish;
    public void kazakhMenu() {
        System.out.println("This is our Kazakh cuisine!:) " +
                "Please select from the menu what you want to order:");
        System.out.println( "1.Beshbarmak\n2.Mantas\n3.Kuyrdak");
        System.out.println("Choose:");
        int orderKazakhDish = new Scanner(System.in).nextInt();
        switch (orderKazakhDish) {
            case 1:
                myDish= String.valueOf(kazakhDish.createDish(DishCategory.BESHBARMAK));;
                calculate.addCalculate(kazakhDish.createDish(DishCategory.BESHBARMAK));
                calculate.getDish();
                break;
            case 2:
                myDish= String.valueOf(kazakhDish.createDish(DishCategory.MANTAS));
                calculate.addCalculate(kazakhDish.createDish(DishCategory.MANTAS));
                calculate.getDish();
                break;
            case 3:
                myDish= String.valueOf(kazakhDish.createDish(DishCategory.QUYRDAQ));
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
                myDish= String.valueOf(italianDish.createDish(DishCategory.PASTA));
                break;
            case 2:
                myDish= String.valueOf(italianDish.createDish(DishCategory.LAZAGNA));
                break;
            case 3:
                myDish= String.valueOf(italianDish.createDish(DishCategory.RISOTTO));
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
                myDish= String.valueOf(koreanDish.createDish(DishCategory.RAMEN));
                break;
            case 2:
                myDish= String.valueOf(koreanDish.createDish(DishCategory.SUSHI));
                break;
            case 3:
                myDish= String.valueOf(koreanDish.createDish(DishCategory.TTEOKPOKKI));
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
                myDish= String.valueOf(drinks.getDrinkFactory().get(orderDrinkDish - 1).makeDrink());

                System.out.println(myDish+ " is ordered ");
        }
}
