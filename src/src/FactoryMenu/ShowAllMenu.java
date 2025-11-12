package FactoryMenu;
import FactoryMenu.Dishes.Drinks.DrinkCreator;
import FactoryMenu.Dishes.ItalianCuisine.*;
import FactoryMenu.Dishes.KoreanCuisine.*;
import FactoryMenu.Dishes.KazakhCuisine.KazakhDish;
import Decorator.DishDecorator;

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
        DrinkCreator drinkSet=new DrinkCreator();
        drinkSet.setDishes();
        drinkSet.displayDishes();
        System.out.println("Extras: \n - Bread : 200₸" +
                                   "\n - Salad : 200₸" +
                                   "\n - Sauce : 500₸");
    }
}
