package usableitems;

import utils.SpelerSession;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

public class JeffDeAssistent extends UsableItem implements IInformatie {

    private static final List<String> MOTIVATIE_BERICHTEN = Arrays.asList(
        "Je kunt het! Blijf doorgaan!",
        "Elke stap brengt je dichter bij de overwinning!",
        "Fouten maken mag, opgeven niet!",
        "Samen staan we sterker!",
        "Blijf geloven in jezelf!"
    );
    private static final List<String> ALGEMENE_HINTS = Arrays.asList(
        "Lees de vraag goed door voordat je antwoordt.",
        "Let op de details in de vraagstelling!",
        "Bedenk goed wat je weet over het onderwerp van de kamer.",
        "Controleer of je antwoord logisch klinkt.",
        "Neem goed de tijd om na te denken voordat je antwoordt."
    );
    private static final Random RANDOM = new Random();


    public void showInfo() {
        System.out.println("Jeff zegt:");
        System.out.println("Hier is en hint die je misschien kan helpen!: " + ALGEMENE_HINTS.get(RANDOM.nextInt(ALGEMENE_HINTS.size())));
        System.out.println("Hier is wat informatie over de huidige kamer!: " + SpelerSession.getSpeler().getStatus().getActieveKamer().getKamerInfo());
        System.out.println("Hier is een motiverend bericht!: " + MOTIVATIE_BERICHTEN.get(RANDOM.nextInt(MOTIVATIE_BERICHTEN.size())));
    }


    public JeffDeAssistent() {
        super("Jeff", "Hoi ik ben Jeff en ik leid je door deze hell heen! Ik geef je hints en motiverende berichten om je te helpen slagen in dit spel!");
    }

    public void gebruik() {
        showInfo();
    }

}
