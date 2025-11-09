package FactoryMenu.Dishes;

public class ChickenRice implements Dishes{
    @Override
    public String dishName(){
        return "Chicken Rice";
    }
    @Override
    public int dishPrice(){
        return 2500;
    }
}
