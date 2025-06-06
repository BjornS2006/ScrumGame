package gamelogic;
import usableitems.IUsableItem;
import usableitems.Komkommer;
import java.util.ArrayList;

public class Speler {
        private Status status;
        private ArrayList <IUsableItem> items;

        public void removeItem (String ItemName) {
            for(IUsableItem item : items) {
                if(item.getName().equals(ItemName)) {
                    items.remove(item);
                    break;
                }
            }
        }

        public Speler (Status status) {
            this.status = status;
            items = new ArrayList<>();
            Komkommer komkommer = new Komkommer();
            items.add(komkommer);
        }
        public Status getStatus () {
            return status;
        }
        public void setStatus (Status status) {
            this.status = status;
        }

        private void ensureItemsInitialized() {
            if (items == null) {
                items = new ArrayList<>();
            }
        }

        public ArrayList<IUsableItem> getItems() {
            ensureItemsInitialized();
            return items;
        }

        public void addItem (IUsableItem item) {
            ensureItemsInitialized();
            items.add(item);
        }

        @Override
        public String toString() {
            return "Speler{" +
                    "status=" + status.getPositie() +" " + getStatus().getScore() +
                    '}';
        }
}
