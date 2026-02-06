import java.util.Random;
import java.util.Scanner;

/**
 * Use Case 1: Game Initialization
 */
class GameConfig {

    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_ATTEMPTS = 7;
    private final int MAX_HINTS = 3;
    private int targetNumber;

    public GameConfig() {
        Random random = new Random();
        this.targetNumber = random.nextInt(MAX - MIN + 1) + MIN;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    public int getMaxHints() {
        return MAX_HINTS;
    }

    public void showRules() {
        System.out.println("Guess a number between " + MIN + " and " + MAX);
        System.out.println("You have " + MAX_ATTEMPTS + " attempts.");
        System.out.println("Hints will be provided after wrong guesses.\n");
    }
}

/**
 * Use Case 2: User Guess Submission
 */
class GuessValidator {

    public static String validateGuess(int guess, int target) {
        if (guess == target) {
            return "CORRECT";
        } else if (guess < target) {
            return "LOW";
        }
        return "HIGH";
    }
}

/**
 * Use Case 3: Hint Generation
 */
class HintService {

    public static String generateHint(int target, int hintCount) {
        if (hintCount == 1) {
            return (target % 2 == 0)
                    ? "Hint: Number is EVEN"
                    : "Hint: Number is ODD";
        } else if (hintCount == 2) {
            return (target > 50)
                    ? "Hint: Number is greater than 50"
                    : "Hint: Number is 50 or less";
        }
        return "No more hints available";
    }
}

/**
 * MAIN CLASS
 */
public class GuessingApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Guessing App");

        GameConfig gameConfig = new GameConfig();
        gameConfig.showRules();

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        int hintCount = 0;

        while (attempts < gameConfig.getMaxAttempts()) {

            System.out.print("Enter your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            int guess = scanner.nextInt();
            attempts++;

            String result = GuessValidator.validateGuess(
                    guess,
                    gameConfig.getTargetNumber()
            );

            System.out.println(result);

            if ("CORRECT".equals(result)) {
                System.out.println("You won in " + attempts + " attempts!");
                break;
            }

            if (hintCount < gameConfig.getMaxHints()) {
                hintCount++;
                System.out.println(
                        HintService.generateHint(
                                gameConfig.getTargetNumber(),
                                hintCount
                        )
                );
            }
        }

        if (attempts == gameConfig.getMaxAttempts()) {
            System.out.println("Game Over! The number was: "
                    + gameConfig.getTargetNumber());
        }
    }
}
