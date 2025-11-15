package Decorator;
import FactoryMenu.Dish;
import Observer.Observer;

public class SauceDecorator extends DishDecorator {
    public SauceDecorator(Dish dish) {
        super(dish);
    }
    @Override
    public String dishName() {
        return dish.dishName() + " + sauce";
    }
    @Override
    public int getDishPrice(){
        return dish.getDishPrice() + 200;
    }

}
