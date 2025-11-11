package FactoryMenu.Dishes;
import java.util.List;
public interface DishCreator {
    Dish createDish(DishCategory dish);
    List<Dish> getDishes();
    void displayDishes();
}
