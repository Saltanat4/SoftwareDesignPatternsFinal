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
        System.out.println(kazakhDish.getDishes());
        KoreanDish koreanDish=new KoreanDish();
        koreanDish.setDishes();
        System.out.println(koreanDish.getDishes());
        ItalianDish italianDish=new ItalianDish();
        italianDish.setDishes();
        System.out.println(italianDish.getDishes());
        DrinkSet drinkSet=new DrinkSet();
        System.out.println(drinkSet.getDrinkFactory());
    }
}
