package Decorator;
import FactoryMenu.Dish;
import Observer.*;

public  class BreadDecorator extends DishDecorator {
    public BreadDecorator(Dish dish) {
        super(dish);
    }
    @Override
    public String dishName(){
        return super.dish.dishName()+" + bread";
    }
    @Override
    public int getDishPrice() {
        return super.dish.getDishPrice() + 200;
    }

}
