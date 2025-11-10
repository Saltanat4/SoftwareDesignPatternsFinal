package FactoryMenu.Dishes.ItalianCuisine;

import FactoryMenu.Dishes.Dish;
import FactoryMenu.Dishes.DishCreator;
import FactoryMenu.Dishes.DishCategory;

import java.util.ArrayList;

public class ItalianDish implements DishCreator{
    ArrayList<Dish> dishes = new ArrayList<>();
    @Override
    public Dish createDish(DishCategory dish) {
        return switch (dish){
            case PASTA -> new Pasta();
            case LAZAGNA -> new Lasagna();
            case RISOTTO -> new Risotto();
            default -> throw new IllegalStateException("Unexpected value: " + dish);
        };
    }
    public void setDishes(){
        dishes.add(new Pasta());
        dishes.add(new Lasagna());
        dishes.add(new Risotto());
    }
    public ArrayList<Dish> getDishes() {
        System.out.print("Italian Dishes: ");
        return dishes;
    }
}
