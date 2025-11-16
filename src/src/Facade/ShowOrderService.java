package Facade;

import FactoryMenu.Dish;

import java.util.List;


public class ShowOrderService {

    public void showOrderedDishes(List<Dish> orderDishes, int totalPrice){
        for (Dish orderDish : orderDishes) {
            System.out.println(orderDish.dishName() + " " + orderDish.getDishPrice());
        }
        System.out.println("Total Price: " + totalPrice);
    }
}
