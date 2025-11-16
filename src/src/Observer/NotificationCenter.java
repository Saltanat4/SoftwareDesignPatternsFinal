package Observer;

import java.util.ArrayList;
import java.util.List;

public class NotificationCenter implements Subject {
    private final List<Observer> observers=new ArrayList<>();
    private String message;
    @Override
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
    @Override
    public void setMessage(String message){
        this.message=message;
        notifyObservers();
    }
}
