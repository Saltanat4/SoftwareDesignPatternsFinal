package FactoryMenu;

import Observer.*;

public interface Dish {
    String dishName();
    int getDishPrice();
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
    public void setMessage(String message);
}
