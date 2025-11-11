package FactoryMenu.Dishes;
import java.util.List;
public interface DishFactory {
    Dish createDish(DishCategory dish);
    List<Dish> getDishes();
    void displayDishes();
}
