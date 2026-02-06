import java.util.Scanner;

public class GuessingApp{

    public static boolean restartGame() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to play again? (yes/no): ");
        String choice = scanner.next();

        return choice.equalsIgnoreCase("yes");
    }

    // main method to run the code
    public static void main(String[] args) {

        boolean restart = restartGame();

        System.out.println("Restart game: " + restart);
    }
}
