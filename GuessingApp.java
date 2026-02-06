import java.util.Random;

public class GuessingApp {

    // Game configuration constants
    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_ATTEMPTS = 5;

    // Target number to guess
    private int targetNumber;

    // ✅ Constructor – SAME name as class
    public GuessingApp() {
        Random random = new Random();
        targetNumber = random.nextInt(MAX - MIN + 1) + MIN;

        displayWelcomeMessage();
    }

    // Welcome message and rules
    private void displayWelcomeMessage() {
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Rules:");
        System.out.println("- Guess a number between " + MIN + " and " + MAX);
        System.out.println("- Maximum attempts allowed: " + MAX_ATTEMPTS);
        System.out.println("--------------------------------");
    }

    // Getter for target number
    public int getTargetNumber() {
        return targetNumber;
    }

    // Getter for max attempts
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    // Optional: main method to test
    public static void main(String[] args) {
        new GuessingApp(); // object creation triggers constructor
    }
}
