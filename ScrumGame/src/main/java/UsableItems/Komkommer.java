package UsableItems;

public class Komkommer extends UsableItem implements I_UsableItem, I_Magie {
    public Komkommer() {
        super("Komkommer", "Een magische komkommer.");
    }

    public void gebruik () {
        System.out.println("Hallo ik ben een komkommer, je hebt niks aan me.");
    }
}
