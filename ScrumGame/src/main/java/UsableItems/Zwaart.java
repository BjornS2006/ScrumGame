package UsableItems;

public class Zwaart extends UsableItem implements I_UsebleItem, I_Wapen{
    //public void ValAan() {
   //
   // }

    public Zwaart(String name, String description) {
        super("name", "description");
    }

    public void gebruik (){
        System.out.println("Swoosh");
    }
}
