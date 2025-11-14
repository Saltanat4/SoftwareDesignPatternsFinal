package Builder;

import java.util.List;
import FactoryMenu.Dish;
import java.util.ArrayList;

public class Order {
    private final List<Dish> dishes;
    private final String customerName;
    private final double discount;
    private final int totalPrice;

    @Override
    public String toString() {
        System.out.println("=== Discount<>Check ===");
        System.out.println("Customer: " + customerName);
        System.out.println("Dishes:");
        for (Dish dish : dishes) {
            System.out.println(" - " + dish.dishName() + " : " + dish.getDishPrice());
        }
        System.out.println("Discount: " + discount * 100 + "%");
        System.out.println("Total Price: " + totalPrice);
        return " ";
    }
    private Order(OrderBuilder builder) {
        this.dishes = builder.dishes;
        this.customerName = builder.customerName;
        this.discount = builder.discount;
        this.totalPrice = builder.totalPrice;
    }

    public static class OrderBuilder {
        private List<Dish> dishes = new ArrayList<>();
        private String customerName;
        private double discount = 0;
        private int totalPrice = 0;

        public OrderBuilder addSetDish(Dish dish) {
            this.dishes.add(dish);
            return this;
        }

        public OrderBuilder setCustomerName(String name) {
            this.customerName = name;
            return this;
        }
        public OrderBuilder setTotalPrice(int price) {
            this.totalPrice = price;
            return this;
        }

        public OrderBuilder setDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        public Order build() {
            System.out.println("check with discount: ");
            totalPrice = (int) (totalPrice - totalPrice * discount);
            return new Order(this);
        }
    }
}
