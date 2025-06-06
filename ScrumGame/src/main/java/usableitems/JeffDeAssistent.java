package usableitems;

public class JeffDeAssistent extends UsableItem implements I_Informatie {

    private String informatie;

    public void ShowInfo() {
        System.out.println("Jeff zegt:");
        System.out.println(informatie);
    }


    public JeffDeAssistent(String informatie) {
        super("Jeff", "Hoi ik ben Jeff en ik leid je door deze hell heen.");
        this.informatie = informatie;
    }

    public void gebruik() {
        ShowInfo();
    }

}
