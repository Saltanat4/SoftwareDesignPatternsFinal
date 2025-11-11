package FactoryMenu.Dishes.Drinks;
import FactoryMenu.Dishes.Dish;

public class Juice implements Dish{
    @Override
    public String dishName() {
        return "Juice";
    }
    @Override
    public int getDishPrice() {
        return 500;
    }
}
