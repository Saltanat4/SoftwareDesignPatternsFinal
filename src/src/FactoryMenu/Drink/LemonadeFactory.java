package FactoryMenu.Drink;

public class LemonadeFactory extends DrinkFactory {
    @Override
    public Drink makeDrink() {
        return new Lemonade();
    }
}
