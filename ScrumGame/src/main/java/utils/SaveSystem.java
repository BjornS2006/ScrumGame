package utils;

import gamelogic.Speler;
import gamelogic.Status;
import com.google.gson.*;
import usableitems.IUsableItem;
import usableitems.Zwaard;
import usableitems.Komkommer;
import usableitems.KamerInforBoek;
import joker.KeyJoker;
import joker.HintJoker;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class SaveSystem implements SaveSystemInterface {
    private static final String FILE_PATH = "Save.json";
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(IUsableItem.class, new JsonDeserializer<IUsableItem>() {
                @Override
                public IUsableItem deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                    JsonObject obj = json.getAsJsonObject();
                    String type = obj.get("type").getAsString();
                    return switch (type) {
                        case "Zwaard" -> context.deserialize(json, Zwaard.class);
                        case "Komkommer" -> context.deserialize(json, Komkommer.class);
                        case "KamerInforBoek" -> context.deserialize(json, KamerInforBoek.class);
                        case "KeyJoker" -> context.deserialize(json, KeyJoker.class);
                        case "HintJoker" -> context.deserialize(json, HintJoker.class);
                        default -> throw new JsonParseException("Unknown item type: " + type);
                    };
                }
            })
            .registerTypeAdapter(IUsableItem.class, (JsonSerializer<IUsableItem>) (src, typeOfSrc, context) -> {
                JsonObject obj = (JsonObject) context.serialize(src, src.getClass());
                obj.addProperty("type", src.getClass().getSimpleName());
                return obj;
            })
            .create();

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
    public void reset() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write("");
        } catch (IOException e) {
            System.err.println("Error resetting save file: " + e.getMessage());
        }
        saveGame(createDefaultSpeler());
    }

    private Speler createDefaultSpeler() {
        Status defaultStatus = new Status(0, "Start", this);
        return new Speler(defaultStatus);
    }
}