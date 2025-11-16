package Facade;

import FactoryMenu.Dishes.Drinks.*;
import FactoryMenu.Dishes.ItalianCuisine.*;
import FactoryMenu.Dishes.KazakhCuisine.*;
import FactoryMenu.Dishes.KoreanCuisine.*;

public class MenuService {
    private final KazakhDish kazakhDishes=new KazakhDish();
    private final ItalianDish italianDishes=new ItalianDish();
    private final KoreanDish koreanDishes=new KoreanDish();
    private final DrinkCreator drinks=new DrinkCreator();

    public void showMenu(){
        System.out.println("===Kazakh cuisine===");
        kazakhDishes.setKazakhDish();
        kazakhDishes.displayDishes();
        System.out.println("===Italian cuisine===");
        italianDishes.setDishes();
        italianDishes.displayDishes();
        System.out.println("===Korean cuisine===");
        koreanDishes.setDishes();
        koreanDishes.displayDishes();
        System.out.println("===Drinks===");
        drinks.setDishes();
        drinks.displayDishes();
    }
}
