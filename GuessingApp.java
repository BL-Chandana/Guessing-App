import java.io.FileWriter;
import java.io.IOException;

public class GuessingApp {

    public static void saveResult(String result) {
        try {
            FileWriter writer = new FileWriter("game_results.txt", true);
            writer.write(result + "\n");
            writer.close();
            System.out.println("Game result saved successfully.");
        } catch (IOException e) {
            System.out.println("Error while saving game result.");
        }
    }

    // main method to run in Eclipse
    public static void main(String[] args) {
        saveResult("Test Result");
    }
}
