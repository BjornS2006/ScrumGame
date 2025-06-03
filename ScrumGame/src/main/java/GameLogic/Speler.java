package GameLogic;
import UsableItems.I_UsebleItem;
import UsableItems.Komkommer;
import UsableItems.UsableItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Speler {
        private Status status;
        private transient ArrayList <I_UsebleItem> items;

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

        public ArrayList<I_UsebleItem> getItems() {
            ensureItemsInitialized();
            return items;
        }

        public void addItem (I_UsebleItem item) {
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
