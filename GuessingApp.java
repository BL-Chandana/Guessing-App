public class GuessingApp {

    public static void main(String[] args) {

        int guess = 10;
        int target = 20;

        String result = validateGuess(guess, target);
        System.out.println(result);
    }

    public static String validateGuess(int guess, int target) {
        if (guess == target) {
            return "CORRECT";
        } else if (guess > target) {
            return "HIGH";
        } else {
            return "LOW";
        }
    }
}

