package FactoryMenu.Dishes;

public abstract class DishFactory {
    abstract Dishes makeDish();

    public void showDish(){
        Dishes dish = makeDish();
        System.out.println(dish);
    }
}
