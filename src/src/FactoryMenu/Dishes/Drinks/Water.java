package FactoryMenu.Dishes.Drinks;
import FactoryMenu.Dishes.Dish;
public class Water implements Dish{
    @Override
    public String dishName(){
        return "Water";
    }
    @Override
    public int getDishPrice(){
        return 300;
    }
}
