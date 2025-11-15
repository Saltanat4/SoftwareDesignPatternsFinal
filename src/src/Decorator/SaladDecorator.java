package Decorator;

import FactoryMenu.Dish;
import Observer.Observer;

public class SaladDecorator extends DishDecorator {
    public SaladDecorator(Dish dish) {
        super(dish);
    }
    @Override
    public String dishName() {
        return super.dishName() + " + salad";
    }
    @Override
    public int getDishPrice() {
        return dish.getDishPrice() + 500;
    }

}
