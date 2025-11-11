package FactoryMenu.Dishes.Drinks;

import FactoryMenu.Dishes.Dish;

public class Lemonade implements Dish{
    int price=700;
    @Override
    public String dishName() {
        return "Lemonade";
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
