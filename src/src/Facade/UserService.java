package Facade;

import Observer.UserObserver;

public class UserService {

    private final UserManager userManager = new UserManager();
    private final NotificationService notification = new NotificationService();
    private final UserObserver observer = new UserObserver();

    public boolean isLoggedIn=false;


    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void register() {
        userManager.register();
        isLoggedIn=true;
    }

    public void login() {
        userManager.login();
        isLoggedIn=true;
    }

    public void logout() {
        notification.notify("You are logged out. Goodbye!", observer);
        isLoggedIn=false;
    }

    public void addNewUser() {
        userManager.register();
        notification.notify("New user account added!", observer);
        isLoggedIn=false;
    }
}
