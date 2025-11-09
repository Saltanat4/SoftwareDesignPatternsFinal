package FactoryMenu.Dishes;

public class Pizza implements Dishes{
    @Override
    public String dishName(){
        return "Pizza";
    }
    @Override
    public int dishPrice(){
        return 1500;
    }
}
