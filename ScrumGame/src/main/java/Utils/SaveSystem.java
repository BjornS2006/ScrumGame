package Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.ArrayList;
import GameLogic.Speler;

public class SaveSystem {
    private static final String FILE_PATH = "Save.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Speler opslaan naar bestand
    public static void saveGame(Speler speler) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(speler, writer);
            System.out.println("Spelergegevens opgeslagen!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Speler laden vanuit bestand
    public static Speler loadGame() {
        File file = new File(FILE_PATH);

        // Als het bestand niet bestaadt
        if (!file.exists()) {
            return createDefaultSpeler();
        }

        try (Reader reader = new FileReader(FILE_PATH)) {
            return gson.fromJson(reader, Speler.class);
        } catch (IOException e) {
            e.printStackTrace();
            return createDefaultSpeler();
        }
    }

    // Als er nog geen gegevens zijn
    private static Speler createDefaultSpeler() {
        return new Speler(0, "Startlocatie");
    }
}