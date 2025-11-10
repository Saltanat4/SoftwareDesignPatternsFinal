package FactoryMenu.Drink;

import java.util.ArrayList;
import java.util.List;

public class DrinkSet {
    private final List<DrinkFactory> drinks = new ArrayList<>();

    public DrinkSet() {
        addDrinkFactory();
    }

    private void addDrinkFactory() {
        drinks.add(new JuiceFactory());
        drinks.add(new WaterFactory());
        drinks.add(new LemonadeFactory());
    }

    public List<DrinkFactory> getDrinkFactory() {
        System.out.print("Drinks: ");
        return drinks;
    }

    public void displayDrinks() {
        int index = 1;
        for (DrinkFactory factory : drinks) {
            Drink drink = factory.makeDrink();
            System.out.println(index++ + ". " + drink.drinkName() + " => " + drink.drinkPrice());
        }
    }
}
