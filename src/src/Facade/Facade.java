package Facade;

import FactoryMenu.Dishes.*;
import FactoryMenu.Dishes.Calculate;
import FactoryMenu.Dishes.Drinks.DrinkCreator;
import FactoryMenu.Dishes.Drinks.*;
import FactoryMenu.Dishes.KazakhCuisine.*;
import FactoryMenu.Dishes.ItalianCuisine.*;
import FactoryMenu.Dishes.KoreanCuisine.*;
import FactoryMenu.ShowAllMenu;

import java.util.Scanner;

public class Facade {
    int cuisineChoice;
    boolean running=true;
    String currentUser=null;
    UserManager userManager=new UserManager(new Scanner(System.in));
    DishCreator kazakhDish=new KazakhDish();
    DishCreator italianDish=new ItalianDish();
    DishCreator koreanDish=new KoreanDish();
    DishCreator drinks=new DrinkCreator();
    ShowAllMenu showAllMenu=new ShowAllMenu();

    Calculate calculate=new Calculate();
    boolean ifUser=false;
    public void userInput(){
        while(!ifUser){
        System.out.println("1.Registration\n2.LogIn");
        int userChoice= new Scanner(System.in).nextInt();
        switch(userChoice){
            case 1:
                userManager.register();
                break;
            case 2:
                boolean ok = userManager.login();
                if(ok){
                    System.out.println("Write your session name!");
                    currentUser=new Scanner(System.in).nextLine();
                    ifUser=true;
                }
                break;
        default:
            System.out.println("Invalid choice\n");
            break;}
        }
    }
    public void mainMenu() {
        userInput();
        while(running && ifUser){
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
                            total=total+ calculate.getDish();
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

    public void cuisineMenu() {
        System.out.println("Now you can order food and drinks.\n(for finish order '0')");
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
                calculate.addCalculate(myDish);
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
        System.out.println("1.Lemonade\n2.Juice\n3.Water");
        System.out.println("Choose:");
        int orderDrink = new Scanner(System.in).nextInt();
        switch (orderDrink) {
            case 1:
                myDish= drinks.createDish(DishCategory.LEMONADE);
                calculate.addCalculate(drinks.createDish(DishCategory.LEMONADE));
                calculate.getDish();
                break;
            case 2:
                myDish= drinks.createDish(DishCategory.JUICE);
                calculate.addCalculate(drinks.createDish(DishCategory.JUICE));
                calculate.getDish();
                break;
            case 3:
                myDish=drinks.createDish(DishCategory.WATER);
                calculate.addCalculate(drinks.createDish(DishCategory.WATER));
                calculate.getDish();
                break;
            default:
                System.out.println("Invalid choice.");
        }
        System.out.println(myDish+ " is ordered");
        }
}
