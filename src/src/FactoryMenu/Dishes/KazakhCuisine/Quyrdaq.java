package FactoryMenu.Dishes.KazakhCuisine;

import FactoryMenu.Dishes.Dish;

public class Quyrdaq implements Dish {
    int price=2500;
    @Override
    public String dishName(){
        return "Quyirdaq";
    }
    @Override
    public int getDishPrice(){
        return price;
    }
    @Override
    public String toString() {
        return dishName();
    }
}
