package FactoryMenu.Dishes.Drinks;

import FactoryMenu.Dishes.Dish;
import FactoryMenu.Dishes.DishCategory;
import FactoryMenu.Dishes.DishFactory;

import java.util.ArrayList;
import java.util.List;

public class DrinkCreator implements DishFactory {
    ArrayList<Dish> dishes = new ArrayList<>();


    @Override
    public Dish createDish(DishCategory dish){
        return switch (dish){
            case LEMONADE -> new Lemonade();
            case JUICE -> new Juice();
            case WATER -> new Water();
            default -> throw new IllegalStateException("Unexpected value: " + dish);
        };
    }
    public void setDishes(){
        dishes.add(new Lemonade());
        dishes.add(new Juice());
        dishes.add(new Water());
    }
    @Override
    public List<Dish> getDishes(){
        System.out.print("Drinks: ");
        return dishes;
    }
    public void displayDishes() {
        System.out.println("Drinks:");
        dishes.forEach(dish -> System.out.println(" - " + dish.dishName() + " : " + dish.getDishPrice() + "₸"));
    }
}
