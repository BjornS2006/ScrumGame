package Utils;

import GameLogic.Speler;
import GameLogic.Status;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import UsableItems.I_UsebleItem;
import UsableItems.Komkommer;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class SaveSystem implements SaveSystemInterface {
    private static final String FILE_PATH = "Save.json";
    private static final Gson gson = new GsonBuilder().create();

    @Override
    public void saveGame(Speler speler) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(speler, writer);
        } catch (IOException e) {
            System.err.println("Error saving game: " + e.getMessage());
        }
    }

    @Override
    public Speler loadGame() {
        File saveFile = new File(FILE_PATH);
        if (!saveFile.exists()) {
            Speler defaultSpeler = createDefaultSpeler();
            saveGame(defaultSpeler);
        }
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Speler speler = gson.fromJson(reader, Speler.class);
            if (speler == null) {
                return createDefaultSpeler();
            }
            return speler;
        } catch (IOException e) {
            System.err.println("Error loading game: " + e.getMessage());
            return createDefaultSpeler();
        }
    }
    @Override
    public void Reset() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(""); // Clear the file content
        } catch (IOException e) {
            System.err.println("Error resetting save file: " + e.getMessage());
        }
        // Ensure a default Speler is created after reset
        saveGame(createDefaultSpeler());
    }

    private Speler createDefaultSpeler() {
        Status defaultStatus = new Status(0, "Start", this);
        return new Speler(defaultStatus);
    }
}

