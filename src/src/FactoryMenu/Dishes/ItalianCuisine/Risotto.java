package FactoryMenu.Dishes.ItalianCuisine;
import FactoryMenu.Dish;

public class Risotto implements Dish{
    int price=2500;
    @Override
    public String dishName() {
        return "Risotto";
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