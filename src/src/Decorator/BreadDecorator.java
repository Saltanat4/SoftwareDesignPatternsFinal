package Decorator;
import FactoryMenu.Dishes.Dish;

import java.util.List;

public class BreadDecorator extends DishDecorator {
    public BreadDecorator(
            Dish dish) {
        super(dish);
    }
    @Override
    public String dishName(){
        return super.dish.dishName()+" Bread";
    }
    @Override
    public int getDishPrice() {
        return super.dish.getDishPrice() + 200;
    }
}
