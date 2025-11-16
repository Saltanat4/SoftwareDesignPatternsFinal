package Facade;

import Observer.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private final List<User> users = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);
    private String name;
    private String password;
    public userObserver userObserver=new userObserver();
    private final User user=new User(name,password);

    public void register() {
        System.out.println("===Registering User===\nPlease enter your name: ");
        name = sc.nextLine();
        System.out.println("Password: ");
        password = sc.nextLine();
        while (password.length() < 8) {
            System.out.println("Please enter a password that is at least 8 characters long!");
            password = sc.nextLine();
        }
        User newUser = new User(name, password);
        users.add(newUser);

        newUser.addObserver(userObserver);
        newUser.setMessage("Welcome, " + name + " to our online Pick Me restaurant! You are successfully registered!");
        newUser.removeObserver(userObserver);
    }

    public void login() {
        System.out.println("===Login User===");
        System.out.println("Please enter your name: ");
        String name = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        for (User u : users) {
            if (u.getName().equals(name) && u.getPassword().equals(password)) {
                user.addObserver(userObserver);
                user.setMessage("Welcome, " + name + " to our online Pick Me restaurant! You are successfully registered!");
                user.removeObserver(userObserver);
                return;
            } else {
                user.addObserver(userObserver);
                user.setMessage("Invalid username or password! Please try again!");
                user.removeObserver(userObserver);
                login();
            }
        }
    }
}