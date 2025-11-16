package FactoryMenu.Dishes.ItalianCuisine;

import FactoryMenu.Dish;
import FactoryMenu.DishFactory;
import FactoryMenu.DishCategory;

import java.util.ArrayList;

public class ItalianDish implements DishFactory {
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
        System.out.print("ItalianSubject Dishes: ");
        return dishes;
    }
    public void displayDishes() {
        System.out.println("ItalianSubject Dishes:");
        dishes.forEach(dish -> System.out.println(" - " + dish.dishName() + " : " + dish.getDishPrice() + "₸"));
    }
}
