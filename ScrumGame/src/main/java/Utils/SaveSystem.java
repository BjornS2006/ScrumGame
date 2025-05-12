package Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import GameLogic.Speler;

public class SaveSystem {
    private static final String FILE_PATH = "Save.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public static void main(String[] args) {
        createDefaultSpeler();
    }
    // Save the Speler to a JSON file
    public static void saveGame(Speler speler) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(speler, writer);
            System.out.println("Spelergegevens opgeslagen!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load the Speler from a JSON file
    public static Speler loadGame() {
        File file = new File(FILE_PATH);

        // If the file does not exist, create a default Speler
        if (!file.exists()) {
            return createDefaultSpeler();
        }

        try (Reader reader = new FileReader(file)) {
            return gson.fromJson(reader, Speler.class);
        } catch (IOException e) {
            e.printStackTrace();
            return createDefaultSpeler();
        }
    }

    // Create a default Speler with an empty vragenGeschiedenis list
    private static Speler createDefaultSpeler() {
        Speler defaultSpeler = new Speler(0, "Startlocatie");
        defaultSpeler.setVragenGeschiedenis(new ArrayList<>());
        return defaultSpeler;
    }
}
