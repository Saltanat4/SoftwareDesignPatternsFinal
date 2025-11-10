package FactoryMenu.Dishes.KazakhCuisine;

import FactoryMenu.Dishes.Dish;

public class Mantas implements Dish {
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
}
