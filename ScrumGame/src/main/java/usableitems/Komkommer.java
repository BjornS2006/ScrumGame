package usableitems;

public class Komkommer extends UsableItem implements IUsableItem, IMagie {
    public Komkommer() {
        super("Komkommer", "Een magische komkommer.");
    }

    public void gebruik () {
        System.out.println("Hallo ik ben een komkommer, je hebt niks aan me.");

    }

}
