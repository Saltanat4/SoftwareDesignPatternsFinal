package FactoryMenu.Dishes.KoreanCuisine;

import FactoryMenu.Dish;

public class Ramen implements Dish {
    int price=2000;
    @Override
    public String dishName() {
        return "Ramen";
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
