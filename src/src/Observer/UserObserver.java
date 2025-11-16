package Observer;

public class UserObserver implements Observer {
    public String message;
    @Override
    public void update(String message) {
        this.message=message;
        user();
    }
    public void user(){
        System.out.println("[PICK ME RESTAURANT] " + message);
    }
}
