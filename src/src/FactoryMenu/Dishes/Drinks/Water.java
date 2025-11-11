package FactoryMenu.Dishes.Drinks;
import FactoryMenu.Dishes.Dish;
public class Water implements Dish{
    int price=300;
    @Override
    public String dishName(){
        return "Water";
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
