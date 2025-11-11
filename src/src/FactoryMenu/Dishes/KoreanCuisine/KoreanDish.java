package FactoryMenu.Dishes.KoreanCuisine;

import FactoryMenu.Dishes.Dish;
import FactoryMenu.Dishes.DishCreator;
import FactoryMenu.Dishes.DishCategory;
import java.util.ArrayList;

public class KoreanDish implements DishCreator{
    ArrayList<Dish> dishes = new ArrayList<>();
    @Override
    public Dish createDish(DishCategory dish){
        return switch(dish){
            case RAMEN -> new Ramen();
            case SUSHI -> new Sushi();
            case TTEOKPOKKI -> new Tteokpokki();
            default -> throw new IllegalStateException("Unexpected value: " + dish);
        };
    }
    public void setDishes(){
        dishes.add(new Ramen());
        dishes.add(new Sushi());
        dishes.add(new Tteokpokki());
    }
    @Override
    public ArrayList<Dish> getDishes() {
        System.out.print("Korean Dishes: ");
        return dishes;
    }
    public void displayDishes() {
        System.out.println("Korean Dishes:");
        dishes.forEach(dish -> System.out.println(" - " + dish.dishName() + " : " + dish.getDishPrice() + "₸"));
    }

}
