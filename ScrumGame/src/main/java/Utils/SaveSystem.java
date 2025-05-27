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

public class SaveSystem implements SaveSystemInterface {
    private static final String FILE_PATH = "Save.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public void saveGame(Speler speler) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(speler, writer);
            System.out.println("Spelergegevens opgeslagen!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Speler loadGame() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            Speler defaultSpeler = createDefaultSpeler();
            saveGame(defaultSpeler);
            return defaultSpeler;
        }
        try (Reader reader = new FileReader(file)) {
            return gson.fromJson(reader, Speler.class);
        } catch (IOException e) {
            e.printStackTrace();
            Speler defaultSpeler = createDefaultSpeler();
            saveGame(defaultSpeler);
            return defaultSpeler;
        }
    }

    @Override
    public void Reset() {
        Speler defaultSpeler = createDefaultSpeler();
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(defaultSpeler, writer);
            System.out.println("Spelergegevens gereset!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Speler createDefaultSpeler() {
        return new Speler(new Status(0, "Start", this));
    }
}
