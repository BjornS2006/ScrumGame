package UsableItems;

public class Zwaard extends UsableItem implements I_UsableItem, I_Wapen{
    //public void ValAan() {
   //
   // }

    public Zwaard(String name, String description) {
        super("name", "description");
    }

    public void gebruik (){
        System.out.println("Swoosh");
    }
}
