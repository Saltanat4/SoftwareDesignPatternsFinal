package Decorator;
import FactoryMenu.Dish;
import Observer.*;

public  class BreadDecorator extends DishDecorator {
    private final int cost = 300;
    public BreadDecorator(Dish dish) {
        super(dish);
    }
    @Override
    public String dishName(){
        return dish.dishName()+" + bread";
    }
    @Override
    public int getDishPrice() {
        return dish.getDishPrice() + cost;
    }

}
