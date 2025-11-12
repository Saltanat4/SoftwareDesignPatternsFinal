package Facade;

import FactoryMenu.Dishes.*;
import FactoryMenu.Dishes.Calculate;
import FactoryMenu.ShowAllMenu;
import Builder.*;

import java.util.Scanner;

public class Facade {
    boolean running=true;
    String currentUser=null;
    DishCreator dishCreator=new DishCreator();
    UserManager userManager=new UserManager(new Scanner(System.in));
    ShowAllMenu showAllMenu=new ShowAllMenu();

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
                    dishCreator.cuisineMenu();
                    dishCreator.totalCheck();
                    break;
                case 3:
                    dishCreator.totalCheck();
                    break;
                case 0:
                    running=false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        }
    }
}
