package Facade;

import Observer.NotificationCenter;
import Observer.Observer;

public class NotificationService{
    public NotificationCenter notification=new NotificationCenter();

    public void notify(String message, Observer observer){
        notification.addObserver(observer);
        notification.setMessage(message);
        notification.removeObserver(observer);
    }
}
