package Facade;

import java.util.Scanner;

public class Facade {
    int cuisineChoice;

    public void mainMenu(){

        System.out.println("=====PICK ME RESTAURANT=====" +
                "\nWelcome to our restaurant!");
        System.out.println("1.Choose cuisine\n");
        System.out.println("2.Order dishes\n");
        System.out.println("3.Choose payment method\n");
        System.out.println("0.Exit\n");
        System.out.println("Choose your choice:");
        int mainMenuChoice = new Scanner(System.in).nextInt();
        switch(mainMenuChoice) {
            case 1:
                cuisineMenu();
                break;
            case 2:
                orderMenu();
                break;
            case 3:
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid choice.");
        }

    }

    public void cuisineMenu(){
        System.out.println("What kind of cuisine would you like to try?" +
                "1.Kazakh\n2.Georgian\n3.Korean\nChoose:");
        cuisineChoice = (new Scanner(System.in)).nextInt();
        switch(cuisineChoice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    public void orderMenu(){
        if(cuisineChoice==1){
            System.out.println("This is our Kazakh cuisine! " +
                    "Please select from the menu what you want to order:");
            System.out.println("1.Beshbarmak\n2.Mantas\n3.Kuyrdak\n4.Kazy");
            System.out.println("Choose:");
            int  orderKazakhDish = new Scanner(System.in).nextInt();
        }
        if (cuisineChoice==2){
            System.out.println("This is Georgian cuisine!" +
                    "\nPlease select from the menu what you want to order:");
            System.out.println("1.Khachapuri\n2.Khinkali\n3.Chakapuli\n4.Lobio");
            System.out.println("Choose:");
            int  orderGeorgianDish = new Scanner(System.in).nextInt();

        }
    }
}
