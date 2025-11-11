package FactoryMenu.Dishes.KazakhCuisine;

import FactoryMenu.Dishes.Dish;
import FactoryMenu.Dishes.DishCreator;
import FactoryMenu.Dishes.DishCategory;

import java.util.ArrayList;
import java.util.List;

public class KazakhDish implements DishCreator {
    ArrayList<Dish> dishes= new ArrayList<>();
    @Override
    public Dish createDish(DishCategory dish) {
        return switch (dish) {
            case BESHBARMAK -> new Beshbarmak();
            case MANTAS -> new Mantas();
            case QUYRDAQ -> new Quyrdaq();
            default -> throw new IllegalStateException("Unexpected value: " + dish);
        };
    }
    public void setKazakhDish() {
        dishes.add(new Beshbarmak());
        dishes.add(new Mantas());
        dishes.add(new Quyrdaq());
    }
    public ArrayList<Dish> getDishes() {
        System.out.print("Korean Dishes: ");
        return dishes;
    }
    public void displayDishes() {
        System.out.println("Kazakh Dishes:");
        dishes.forEach(dish -> System.out.println(" - " + dish.dishName() + " : " + dish.getDishPrice() + "₸"));
    }
}
