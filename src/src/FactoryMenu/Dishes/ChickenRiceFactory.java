package FactoryMenu.Dishes;

public class ChickenRiceFactory extends DishFactory{
    @Override
    public Dishes makeDish(){
        return new ChickenRice();
    }
}
