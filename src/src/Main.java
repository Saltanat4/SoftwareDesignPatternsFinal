import Facade.Facade;
import FactoryMenu.Dishes.*;
import FactoryMenu.Dishes.Drinks.*;
import FactoryMenu.*;


public class Main {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.mainMenu();
    }
}
