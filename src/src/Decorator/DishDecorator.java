package Decorator;
import FactoryMenu.Dishes.Dish;
import FactoryMenu.Dishes.DishCreator;

import java.util.List;

public abstract class DishDecorator implements Dish {
    protected Dish dish;
    DishCreator dishCreator=new DishCreator();
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
