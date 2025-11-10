package FactoryMenu.Dishes.ItalianCuisine;
import FactoryMenu.Dishes.Dish;

public class Lasagna implements Dish{
    int price=2500;
    @Override
    public String dishName() {
        return "Lasagna";
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