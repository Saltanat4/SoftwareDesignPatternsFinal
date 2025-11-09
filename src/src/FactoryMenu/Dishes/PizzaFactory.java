package FactoryMenu.Dishes;

public class PizzaFactory extends DishFactory {
    @Override
    public Dishes makeDish() {
        return new Pizza();
    }
}
