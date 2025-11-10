package FactoryMenu.Drink;

public class Water implements Drink {
    @Override
    public String drinkName() {
        return "Water";
    }
    @Override
    public int drinkPrice() {
        return 300;
    }
    @Override
    public String toString(){
        return drinkName();
    }
}
