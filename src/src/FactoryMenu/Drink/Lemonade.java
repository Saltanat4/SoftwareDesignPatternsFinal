package FactoryMenu.Drink;

public class Lemonade implements Drink{
    @Override
    public String drinkName(){
        return "Lemonade";
    }
    @Override
    public int drinkPrice(){
        return 1000;
    }
}
