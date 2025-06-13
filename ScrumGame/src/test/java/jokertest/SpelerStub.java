package jokertest;

import gamelogic.Speler;
import gamelogic.Status;
import usableitems.IUsableItem;

import java.util.ArrayList;
import java.util.List;

public class SpelerStub extends Speler {
    private Status status;
    private ArrayList<IUsableItem> items;

    public SpelerStub(Status status) {
        super(status);
        this.status = status;
        this.items = new ArrayList<>();
    }

    public void setItems(List<IUsableItem> items) {
        this.items = new ArrayList<>(items);
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public ArrayList<IUsableItem> getItems() {
        return items;
    }
}