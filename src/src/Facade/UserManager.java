package Facade;

import Observer.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private final List<User> users = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    NotificationService notificationService = new NotificationService();
    public UserObserver userObserver=new UserObserver();

    public void register() {
        System.out.println("===Registering User===\nPlease enter your name: ");
        String name = sc.nextLine();
        System.out.println("Set password: ");
        String password = sc.nextLine();
        while (password.length() < 8) {
            System.out.println("Please enter a password that is at least 8 characters long!");
            password = sc.nextLine();
        }
        User newUser = new User(name, password);
        users.add(newUser);

        notificationService.notify("Welcome, " + name + " to our online Pick Me restaurant! You are successfully registered!", userObserver);

    }

    public void login() {
        System.out.println("===Login User===");
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        for (User u : users) {
            if (u.getName().equals(name) && u.getPassword().equals(password)) {
                notificationService.notify("Welcome back," + name + " to our online Pick Me restaurant!", userObserver);

                return;
            } else {
                notificationService.notify("Invalid username or password. Tru again!", userObserver);
                login();
            }
        }
    }
}