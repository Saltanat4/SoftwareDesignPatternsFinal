package FactoryMenu.Dishes.KazakhCuisine;

import FactoryMenu.Dish;
import Observer.*;

import java.util.ArrayList;
import java.util.List;

public class Mantas implements Dish, Subject {
    private final List<Observer> observers=new ArrayList<>();
    private String message="";

    int price=3000;
    @Override
    public String dishName(){
        return "Mantas";
    }
    @Override
    public int getDishPrice(){
        return price;
    }
    @Override
    public String toString(){
        return dishName();
    }

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
