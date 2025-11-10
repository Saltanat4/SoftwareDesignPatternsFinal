package FactoryMenu.Dishes.KoreanCuisine;
import FactoryMenu.Dishes.Dish;

public class Tteokpokki implements Dish{
    int price=1500;
    @Override
    public String dishName() {
        return "Tteokpokki";
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
