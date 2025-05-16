package Utils;

import GameLogic.Status;
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
//    locatie van de save file
    private static final String FILE_PATH = "Save.json";
//    maak een Json object aan met google's Gson
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();


//opslaan
    public static void saveGame(Speler speler) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(speler, writer);
            System.out.println("Spelergegevens opgeslagen!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//het laden van het spell
    public static Speler loadGame() {
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            saveGame(createDefaultSpeler());
            return;
        }

        try (Reader reader = new FileReader(file)) {
            Speler savedSpeler = gson.fromJson(reader, Speler.class);
            speler.setId(savedSpeler.getId());
            speler.setLocatie(savedSpeler.getLocatie());
            speler.setVragenGeschiedenis(savedSpeler.getVragenGeschiedenis());
        } catch (IOException e) {
            e.printStackTrace();
            saveGame(createDefaultSpeler());
        }
    }
//als er geen save file is word er een nieuwe speler aa gemaakt
    private static Speler createDefaultSpeler() {
        Speler defaultSpeler = new Speler(new Status(0, "Start"));
        return defaultSpeler;
    }
}
