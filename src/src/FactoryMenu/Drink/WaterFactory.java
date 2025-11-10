package FactoryMenu.Drink;

public class WaterFactory extends DrinkFactory{
    @Override
    public Drink makeDrink(){
        return new Water();
    }
    @Override
    public String toString(){
        return makeDrink().toString();
    }
}
