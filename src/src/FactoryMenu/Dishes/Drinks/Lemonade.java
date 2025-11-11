package FactoryMenu.Dishes.Drinks;

import FactoryMenu.Dishes.Dish;

public class Lemonade implements Dish{
    @Override
    public String dishName() {
        return "Lemonade";
    }
    @Override
    public int getDishPrice() {
        return 700;
    }
}
