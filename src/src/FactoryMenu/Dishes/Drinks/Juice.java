package FactoryMenu.Dishes.Drinks;
import FactoryMenu.Dishes.Dish;

public class Juice implements Dish{
    int price=500;
    @Override
    public String dishName() {
        return "Juice";
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
