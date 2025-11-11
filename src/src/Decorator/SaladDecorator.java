package Decorator;

import FactoryMenu.Dishes.Dish;

public class SaladDecorator extends DishDecorator {
    public SaladDecorator(Dish dish) {
        super(dish);
    }
    @Override
    public String dishName() {
        return super.dishName() + " +Salad";
    }
    @Override
    public int getDishPrice() {
        return dish.getDishPrice() + 500;
    }
}
