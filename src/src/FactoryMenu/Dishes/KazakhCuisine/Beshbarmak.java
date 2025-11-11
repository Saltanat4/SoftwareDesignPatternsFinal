package FactoryMenu.Dishes.KazakhCuisine;
import FactoryMenu.Dishes.Dish;

public class Beshbarmak implements Dish {
    int price=2500;
    @Override
    public String dishName(){
        return "Beshbarmak";
    }
    @Override
    public int getDishPrice(){
        return price;
    }
    @Override
    public String toString() {
        return dishName() ;
    }
}
