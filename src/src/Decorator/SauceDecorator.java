package Decorator;
import FactoryMenu.Dishes.Dish;

public class SauceDecorator extends DishDecorator {
    public SauceDecorator(Dish dish) {
        super(dish);
    }
    @Override
    public String dishName() {
        return dish.dishName() + " +Sauce";
    }
    @Override
    public int getDishPrice(){
        return dish.getDishPrice() + 200;
    }
}
