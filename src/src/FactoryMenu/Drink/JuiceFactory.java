package FactoryMenu.Drink;

public class JuiceFactory extends DrinkFactory {
    @Override
    public Drink makeDrink(){
        return new Juice();
    }
}
