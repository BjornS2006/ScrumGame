package Utils;

import GameLogic.Status;
import GameLogic.Speler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class SaveSystem {
    // Path of the JSON save file.
    private static final String FILE_PATH = "Save.json";
    // Gson object with pretty printing.
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Save the game by writing the player's status to a JSON file.
    public static Speler saveGame(Speler speler) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(speler, writer);
            System.out.println("Spelergegevens opgeslagen!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return speler;
    }

    // Load the game by reading the player's status from the JSON file.
    public static Speler loadGame() {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            // File doesn't exist: create a default player and save it.
            Speler defaultSpeler = createDefaultSpeler();
            saveGame(defaultSpeler);
            return defaultSpeler;
        }

        try (Reader reader = new FileReader(file)) {
            // Deserialize the JSON to construct a Speler instance,
            // which automatically sets its status.
            Speler savedSpeler = gson.fromJson(reader, Speler.class);
            return savedSpeler;
        } catch (IOException e) {
            e.printStackTrace();
            // In case of error, create, save, and return a default player.
            Speler defaultSpeler = createDefaultSpeler();
            saveGame(defaultSpeler);
            return defaultSpeler;
        }
    }

    // Create a default Speler with a default Status.
    private static Speler createDefaultSpeler() {
        return new Speler(new Status(0, "Start"));
    }
}
