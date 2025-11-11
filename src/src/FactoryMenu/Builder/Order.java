package FactoryMenu.Builder;

import FactoryMenu.Dishes.Dish;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Dish> dishes;
    private final String customerName;
    private final String address;
    private final double discount;
    private final int totalPrice;

    private Order(OrderBuilder builder) {
        this.dishes = builder.dishes;
        this.customerName = builder.customerName;
        this.address = builder.address;
        this.discount = builder.discount;
        this.totalPrice = builder.totalPrice;
    }

    public void showOrder() {
        System.out.println("===== ORDER INFO =====");
        System.out.println("Customer: " + customerName);
        System.out.println("Address: " + address);
        System.out.println("Dishes:");
        for (Dish d : dishes) {
            System.out.println(" - " + d.dishName() + " : " + d.getDishPrice());
        }
        System.out.println("Discount: " + discount * 100 + "%");
        System.out.println("Total Price: " + totalPrice);
    }

    public static class OrderBuilder {
        private List<Dish> dishes = new ArrayList<>();
        private String customerName;
        private String address;
        private double discount = 0;
        private int totalPrice = 0;

        public OrderBuilder addDish(Dish dish) {
            dishes.add(dish);
            totalPrice += dish.getDishPrice();
            return this;
        }

        public OrderBuilder setCustomerName(String name) {
            this.customerName = name;
            return this;
        }

        public OrderBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public OrderBuilder setDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        public Order build() {
            totalPrice = (int) (totalPrice - totalPrice * discount);
            return new Order(this);
        }
    }
}
