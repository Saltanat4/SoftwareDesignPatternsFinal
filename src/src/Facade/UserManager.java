package Facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private List<User> users = new ArrayList<User>();
    private Scanner sc = new Scanner(System.in);

    public void register() {
        System.out.println("===Registering User===\nPlease enter your name: ");
        String name = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        while (password.length() < 8) {
            System.out.println("Please enter a password that is at least 8 characters long!");
            password = sc.nextLine();
        }
        User newUser = new User(name, password);
        users.add(newUser);
        System.out.println("Welcome, " + name + " to our online Pick Me restaurant! You are successfully registered!");
    }

    public void login() {
        System.out.println("===Login User===");
        System.out.println("Please enter your name: ");
        String name = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        for (User u : users) {
            if (u.getName().equals(name) && u.getPassword().equals(password)) {
                System.out.println("Welcome back, " + name + " to our online Pick Me restaurant!");
                return;
            } else {
                System.out.println("Invalid username or password!Try again!");
                login();
            }
        }
    }
}