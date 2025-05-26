package UsableItems;

public class KamerInforBoek extends UsableItem implements I_Informatie, I_UsebleItem{
    //public void ShowInfo() {
//
   // }


    public KamerInforBoek(String name, String description) {
        super("name", "description");
    }

    public void gebruik() {
        System.out.println("Oehhhhhh informatie");
    }

}
