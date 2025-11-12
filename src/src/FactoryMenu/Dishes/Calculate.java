package FactoryMenu.Dishes;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    ArrayList<Dish> dishes=new ArrayList<>();
    private int total = 0;

    public void addCalculate(Dish dish) {
        dishes.add(dish);
        System.out.println();
        total += dish.getDishPrice();
    }

    public int getDish() {
        return total;
    }
    public List<Dish> getDishes() {
        return dishes;
    }
    public List<Dish> getOrderedDishes() {
        for(Dish dish:dishes) {
            System.out.println(dish.dishName()+": "+dish.getDishPrice());
        }return dishes;
    }
}