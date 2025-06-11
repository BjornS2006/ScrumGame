package usableitems;

public class Zwaard extends UsableItem implements IUsableItem, IWapen{
    @Override
    public void valAan() {
        System.out.println("Swoosh!");
    }

    public Zwaard() {
        super("Zwaard", "Een zwaard dat je kan gebruiken om een monster te verslaan.");
    }

    public void gebruik (){
        System.out.println("Je zwaait je zwaard naar het monster!");
        valAan();
    }
}
