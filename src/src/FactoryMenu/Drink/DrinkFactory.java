package FactoryMenu.Drink;

public abstract class DrinkFactory{
    public abstract Drink makeDrink();
    public void showDrink(){
        Drink drink = makeDrink();
        System.out.println(drink);
    }
}
