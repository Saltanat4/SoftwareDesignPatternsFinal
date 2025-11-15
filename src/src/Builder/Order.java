package Builder;

import java.util.List;
import FactoryMenu.Dish;
import java.util.ArrayList;

public class Order {
    private final List<Dish> dishes;
    private final int totalPrice;
    boolean discountApplied;

    private Order(List<Dish> dishes, int totalPrice, boolean discountApplied) {
        this.dishes = dishes;
        this.totalPrice = totalPrice;
        this.discountApplied = discountApplied;
    }

    public boolean isDiscountApplied() {
        return discountApplied;
    }
    public List<Dish> getDishes() { return dishes; }
    public int getTotalPrice() { return totalPrice; }

    public static class OrderBuilder {
        private List<Dish> dishes = new ArrayList<>();
        private int totalPrice = 0;
        private boolean miniGamePlayed = false;
        private boolean miniGameWon = false;


        public OrderBuilder addMiniGame(MiniGame game) {
            miniGamePlayed = true;
            miniGameWon = game.play();

            if (miniGameWon) {
                totalPrice = (int)(totalPrice * 0.9);
            }
            return this;
        }
        public OrderBuilder addDish(Dish dish) {
            dishes.add(dish);
            totalPrice += dish.getDishPrice();
            return this;
        }
        public Order build() {
            return new Order(dishes,totalPrice, miniGameWon);
        }
    }
}