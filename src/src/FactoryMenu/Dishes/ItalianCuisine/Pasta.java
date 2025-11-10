package FactoryMenu.Dishes.ItalianCuisine;
import FactoryMenu.Dishes.Dish;

public class Pasta implements Dish{
    int price=2500;
    @Override
    public String dishName() {
        return "Pasta";
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
