package FactoryMenu.Dishes.Drinks;

public interface DrinkObserver {
    public void addObserver(DrinkObserver observer);
    public void removeObserver(DrinkObserver observer);
    public void notifyObservers();
}
