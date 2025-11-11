package Decorator;
import FactoryMenu.Dishes.Dish;

public class BreadDecorator extends DishDecorator {
    public BreadDecorator(Dish dish) {
        super(dish);
    }
    @Override
    public String dishName(){
        return dish.dishName()+" Bread";
    }
    @Override
    public int getDishPrice() {
        return dish.getDishPrice();
    }
}
