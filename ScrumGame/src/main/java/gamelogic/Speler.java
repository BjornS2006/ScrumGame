<<<<<<< HEAD:ScrumGame/src/main/java/GameLogic/Speler.java
package GameLogic;
import UsableItems.I_UsableItem;
import UsableItems.Komkommer;

=======
package gamelogic;
import usableitems.IUsebleItem;
import usableitems.Komkommer;
>>>>>>> Jokertest:ScrumGame/src/main/java/gamelogic/Speler.java
import java.util.ArrayList;

public class Speler {
        private Status status;
<<<<<<< HEAD:ScrumGame/src/main/java/GameLogic/Speler.java
        private transient ArrayList <I_UsableItem> items;

        public void removeItem (String ItemName) {
            for(I_UsableItem item : items) {
                if(item.getName().equals(ItemName)) {
                    items.remove(item);
                    break;
                }
            }
        }
=======
        private ArrayList <IUsebleItem> items;
>>>>>>> Jokertest:ScrumGame/src/main/java/gamelogic/Speler.java

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

<<<<<<< HEAD:ScrumGame/src/main/java/GameLogic/Speler.java

        public ArrayList<I_UsableItem> getItems() {
=======
        // Always ensure items is initialized after deserialization
        private void ensureItemsInitialized() {
>>>>>>> Jokertest:ScrumGame/src/main/java/gamelogic/Speler.java
            if (items == null) {
                items = new ArrayList<>();
            }
        }

        public ArrayList<IUsebleItem> getItems() {
            ensureItemsInitialized();
            return items;
        }

<<<<<<< HEAD:ScrumGame/src/main/java/GameLogic/Speler.java
        public void addItem (I_UsableItem item) {
            if (items == null) {
                items = new ArrayList<>();
            }
=======
        public void addItem (IUsebleItem item) {
            ensureItemsInitialized();
>>>>>>> Jokertest:ScrumGame/src/main/java/gamelogic/Speler.java
            items.add(item);
        }

        @Override
        public String toString() {
            return "Speler{" +
                    "status=" + status.getPositie() +" " + getStatus().getScore() +
                    '}';
        }
}
