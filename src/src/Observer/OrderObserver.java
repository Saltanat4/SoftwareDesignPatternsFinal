package Observer;

public class OrderObserver implements Observer {
    private String message;
    @Override
    public void update(String message) {
        this.message = message;
        order();
    }
    public void order() {
        System.out.println("[USER] "+message);
    }
}
