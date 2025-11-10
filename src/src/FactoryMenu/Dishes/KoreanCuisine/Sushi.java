package FactoryMenu.Dishes.KoreanCuisine;

import FactoryMenu.Dishes.Dish;

public class Sushi implements Dish {
    int price=2500;
    @Override
    public String dishName(){
        return "Sushi";
    }
    @Override
    public int getDishPrice() {
        return price;
    }
    @Override
    public String toString() {
        return dishName();
    }
}
