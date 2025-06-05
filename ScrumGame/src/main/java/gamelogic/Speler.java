package gamelogic;
import usableitems.IUsebleItem;
import usableitems.Komkommer;
import java.util.ArrayList;

public class Speler {
        private Status status;
        private ArrayList <IUsebleItem> items;

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

        // Always ensure items is initialized after deserialization
        private void ensureItemsInitialized() {
            if (items == null) {
                items = new ArrayList<>();
            }
        }

        public ArrayList<IUsebleItem> getItems() {
            ensureItemsInitialized();
            return items;
        }

        public void addItem (IUsebleItem item) {
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
