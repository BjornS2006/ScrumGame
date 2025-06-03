package GameLogic;
import UsableItems.I_UsableItem;
import UsableItems.Komkommer;

import java.util.ArrayList;

public class Speler {
        private Status status;
        private transient ArrayList <I_UsableItem> items;

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


        public ArrayList<I_UsableItem> getItems() {
            if (items == null) {
                items = new ArrayList<>();
            }
            return items;
        }

        public void addItem (I_UsableItem item) {
            if (items == null) {
                items = new ArrayList<>();
            }
            items.add(item);
        }

        @Override
        public String toString() {
            return "Speler{" +
                    "status=" + status.getPositie() +" " + getStatus().getScore() +
                    '}';
        }
}
