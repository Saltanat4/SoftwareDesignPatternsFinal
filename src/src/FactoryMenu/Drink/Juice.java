package FactoryMenu.Drink;

public class Juice implements Drink {
    @Override
    public String drinkName(){
        return "Juice";
    }
    @Override
    public int drinkPrice(){
        return 500;
    }
}
