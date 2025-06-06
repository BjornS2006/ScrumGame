package usableitems;

public class KamerInforBoek extends UsableItem implements IInformatie, IUsableItem {
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
