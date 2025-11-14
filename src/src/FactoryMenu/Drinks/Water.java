package FactoryMenu.Drinks;
import FactoryMenu.Dish;
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
