import java.util.Scanner;

public class GuessingApp {

    // HintService logic inside same file
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

        System.out.println("Enter a number:");
        int number = scanner.nextInt();

        // Call hint method
        HintService.showHint(number);

        scanner.close();
    }
}
