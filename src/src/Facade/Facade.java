package Facade;

import java.util.Scanner;

public class Facade {
    int cuisineChoice;
    boolean running=true;

    public void mainMenu() {
        while(running){
            System.out.println("=====PICK ME RESTAURANT=====" +
                    "\nWelcome to our restaurant!");
            System.out.println("1.Choose cuisine");
            System.out.println("2.Order dishes");
            System.out.println("3.Choose payment method");
            System.out.println("0.Exit");
            System.out.println("Choose your choice:");
            int mainMenuChoice = new Scanner(System.in).nextInt();
            switch (mainMenuChoice) {
                case 1:
                    cuisineMenu();
                    break;
                case 2:
                    switch (cuisineChoice) {
                        case 1:
                            kazakhMenu();
                            break;
                        case 2:
                            georgianMenu();
                            break;
                        case 3:
                            koreanmenu();
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
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

    public void cuisineMenu() {
        System.out.println("What kind of cuisine would you like to try?" +
                "\n1.Kazakh\n2.Georgian\n3.Korean\nChoose:");
        cuisineChoice = (new Scanner(System.in)).nextInt();
        System.out.println("Now you can order food and drinks.");
    }

    public void kazakhMenu() {
        System.out.println("This is our Kazakh cuisine!:) " +
                "Please select from the menu what you want to order:");
        System.out.println("1.Beshbarmak\n2.Mantas\n3.Kuyrdak\n4.Kazy");
        System.out.println("Choose:");
        int orderKazakhDish = new Scanner(System.in).nextInt();
        switch (orderKazakhDish) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid choice.");
        }

    }


    public void georgianMenu() {
        System.out.println("This is Georgian cuisine!" +
                "\nPlease select from the menu what you want to order:");
        System.out.println("1.Khachapuri\n2.Khinkali\n3.Chakapuli\n4.Lobio");
        System.out.println("Choose:");
        int orderGeorgianDish = new Scanner(System.in).nextInt();
        switch (orderGeorgianDish) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid choice.");
        }

    }

    public void koreanmenu() {
        System.out.println("This is Georgian cuisine!" +
                "\nPlease select from the menu what you want to order:");
        System.out.println("1.Mandu\n2.Kimchi\n3.Tokpokki\n4.Kimpab");
        System.out.println("Choose:");
        int orderKoreanDish = new Scanner(System.in).nextInt();
        switch (orderKoreanDish) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
