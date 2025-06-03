package UsableItems;

public class KamerInforBoek extends UsableItem implements I_Informatie, I_UsableItem {
    private String informatie;

    public void ShowInfo() {
        System.out.println("Dit is de informatie die we gaan geven over deze kamer:");
        System.out.println(informatie);
    }


    public KamerInforBoek(String informatie) {
        super("Infoboek", "Dit is een informatie boekje om info te krijgen over de huidige kamer.");
        this.informatie = informatie;
    }

    public void gebruik() {
        ShowInfo();
    }

}
