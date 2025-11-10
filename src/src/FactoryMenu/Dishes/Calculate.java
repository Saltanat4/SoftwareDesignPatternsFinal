package FactoryMenu.Dishes;

import java.util.ArrayList;

public class Calculate {
    ArrayList<Dish> dishes=new ArrayList<>();
    public void addCalculate(Dish dish) {
        dishes.add(dish);
    }
    public int getDish() {
        int total=0;
        for (Dish d : dishes) {
            total +=  d.getDishPrice();
            System.out.println(d+" " + d.getDishPrice()+"tg");
        }return total;
    }
}
