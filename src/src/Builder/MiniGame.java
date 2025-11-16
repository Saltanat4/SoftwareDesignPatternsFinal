package Builder;

import java.util.Random;
import java.util.Scanner;

public class MiniGame {
    private final Scanner scanner = new Scanner(System.in);

    public boolean play() {
        Random random = new Random();
        int secret =random.nextInt(100);
        System.out.println("=== Mini Game: Guess the Number ===");
        System.out.println("Guess a number between 1 and 100:");
        int guess = scanner.nextInt();
        if (guess == secret) {
            System.out.println("You guessed right! 10% discount unlocked!");
            return true;
        } else {
            System.out.println("Wrong! Number was: " + secret);
            return false;
        }
    }
}
