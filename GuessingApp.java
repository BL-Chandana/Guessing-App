import java.util.Scanner;

public class GuessingApp {

    // Validation Service
    static class ValidationService {

        public static boolean isValidGuess(int guess) {
            if (guess < 1 || guess > 100) {
                System.out.println("Invalid input! Please guess between 1 and 100.");
                return false;
            }
            return true;
        }
    }

    // Hint Service
    static class HintService {

        public static void showHint(int targetNumber) {
            if (targetNumber % 2 == 0) {
                System.out.println("Hint: The number is EVEN");
            } else {
                System.out.println("Hint: The number is ODD");
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your guess (1 to 100):");
        int guess = scanner.nextInt();

        if (ValidationService.isValidGuess(guess)) {
            HintService.showHint(guess);
        }

        scanner.close();
    }
}
