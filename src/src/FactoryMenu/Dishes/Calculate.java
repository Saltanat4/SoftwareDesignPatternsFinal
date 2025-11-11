package FactoryMenu.Dishes;

import java.util.ArrayList;

public class Calculate {
    ArrayList<Dish> dishes=new ArrayList<>();
    public void addCalculate(Dish dish) {
        dishes.add(dish);
    }
    public int getDish() {
        int total=0;
        for (Dish dish: dishes) {
            total +=  dish.getDishPrice();
            System.out.println(dish+" " + dish.getDishPrice()+"tg");
        }return total;
    }
}
