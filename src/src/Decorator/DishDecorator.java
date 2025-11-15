package Decorator;
import FactoryMenu.Dish;
import Observer.*;

public class DishDecorator implements Dish{
    protected Dish dish;
    public DishDecorator(Dish dish) {
        this.dish=dish;
    }

    @Override
    public String dishName() {
        return dish.dishName();
    }
    @Override
    public int getDishPrice(){
        return dish.getDishPrice();
    }

}