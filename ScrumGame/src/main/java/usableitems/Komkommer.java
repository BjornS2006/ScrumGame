package usableitems;

<<<<<<< HEAD:ScrumGame/src/main/java/UsableItems/Komkommer.java
public class Komkommer extends UsableItem implements I_UsableItem, I_Magie {
=======
public class Komkommer extends UsableItem implements IUsebleItem, IMagie {
>>>>>>> Jokertest:ScrumGame/src/main/java/usableitems/Komkommer.java
    public Komkommer() {
        super("Komkommer", "Een magische komkommer.");
    }

    public void gebruik () {
        System.out.println("Hallo ik ben een komkommer, je hebt niks aan me.");
    }
}
