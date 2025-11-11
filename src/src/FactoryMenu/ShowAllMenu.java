package FactoryMenu;
import FactoryMenu.Dishes.Dish;
import FactoryMenu.Dishes.DishCategory;
import FactoryMenu.Dishes.DishCreator;
import FactoryMenu.Dishes.ItalianCuisine.*;
import FactoryMenu.Dishes.KoreanCuisine.*;
import FactoryMenu.Drink.*;
import FactoryMenu.Dishes.KazakhCuisine.KazakhDish;
import FactoryMenu.Drink.DrinkFactory;
import FactoryMenu.Drink.LemonadeFactory;

public class ShowAllMenu {
    public void showMenu() {
        KazakhDish kazakhDish=new KazakhDish();
        kazakhDish.setKazakhDish();
        kazakhDish.displayDishes();
        KoreanDish koreanDish=new KoreanDish();
        koreanDish.setDishes();
        koreanDish.displayDishes();
        ItalianDish italianDish=new ItalianDish();
        italianDish.setDishes();
        italianDish.displayDishes();
        DrinkSet drinkSet=new DrinkSet();
        drinkSet.displayDrinks();
    }
}
