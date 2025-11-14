package Facade;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class UserManager{
    private List<UserManager> users=new  ArrayList<UserManager>();
    private  String name;
    private  String password;
    private  int age;
    Scanner sc = new Scanner(System.in);

    public UserManager(String name, String password, int age){
        this.name=name;
        this.password=password;
        this.age=age;
    };

    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public int getAge(){
        return age;
    }

    public void register(){
        System.out.println("Registering User\nPlease enter your name: ");
        name=sc.nextLine();
        System.out.println("Password: ");
        password=sc.nextLine();
        if (password.length() < 8) {
            System.out.println("Please enter a password that is at least 8 characters long!");
            password=sc.nextLine();
        }
        System.out.println("Please enter your age: ");
        age=sc.nextInt();

        System.out.println("Welcome to our online Pick Me restaurant! You are successfully registered!");
    }

    public void login(){

    }
}