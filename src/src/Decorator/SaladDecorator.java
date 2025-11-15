package Decorator;

import FactoryMenu.Dish;
import Observer.Observer;

public class SaladDecorator extends DishDecorator {
    private final int cost = 1500;
    public SaladDecorator(Dish dish) {
        super(dish);
    }
    @Override
    public String dishName() {
        return dish.dishName() + " + salad";
    }
    @Override
    public int getDishPrice() {
        return dish.getDishPrice() + cost;
    }

}
