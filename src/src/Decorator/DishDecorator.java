package Decorator;
import FactoryMenu.Dish;
import Observer.*;

public class DishDecorator implements Dish {
    protected Dish dish;
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

    @Override
    public void addObserver(Observer observer) {
        dish.addObserver(observer);
    };
    @Override
    public void removeObserver(Observer observer) {
        dish.removeObserver(observer);
    }
    @Override
    public void notifyObservers() {
        dish.notifyObservers();
    }

    @Override
    public void setMessage(String message) {
        dish.setMessage(message);
    }
}