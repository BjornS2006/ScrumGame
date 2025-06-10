package usableitems;

public class Zwaard extends UsableItem implements IUsableItem, IWapen{
    @Override
    public void ValAan() {
        System.out.println("Swoosh!");
    }

    public Zwaard(String name, String description) {
        super(name, description);
    }

    public void gebruik (){
        System.out.println("Je zwaait je zwaard naar het monster!");
        ValAan();
    }
}
