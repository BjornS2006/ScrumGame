package usableitems;

public class Zwaart extends UsableItem implements IUsableItem, IWapen {
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
