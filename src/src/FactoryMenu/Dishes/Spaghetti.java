package FactoryMenu.Dishes;

public class Spaghetti implements Dishes{
    @Override
    public String dishName(){
        return "Spaghetti";
    }
    @Override
    public int dishPrice(){
        return 2500;
    }
}
