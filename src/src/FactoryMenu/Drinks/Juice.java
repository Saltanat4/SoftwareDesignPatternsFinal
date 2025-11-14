package FactoryMenu.Drinks;
import FactoryMenu.Dish;

import java.util.ArrayList;
import java.util.List;


public class Juice implements Dish, DrinkObserver{
    private List<DrinkObserver> observers=new ArrayList<>();

    int price=500;
    @Override
    public String dishName() {
        return "Juice";
    }
    @Override
    public int getDishPrice() {
        return price;
    }


    @Override
    public String toString() {
        return dishName();
    }

    @Override
    public void addObserver(DrinkObserver observer){
        observers.add(observer);
    }

    @Override
    public void removeObserver(DrinkObserver observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.notifyObservers());
    }


}
