package FactoryMenu.Dishes;

public class SpaghettiFactory extends DishFactory{
    @Override
    public Dishes makeDish() {
        return new Spaghetti();
    }
}
