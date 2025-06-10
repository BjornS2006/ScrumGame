package gamelogic;
import usableitems.IUsableItem;
import usableitems.Komkommer;
import java.util.ArrayList;

public class Speler {
        private Status status;
        private ArrayList <IUsableItem> items;
        private boolean jokerReceived;
        private boolean firstItemReceived;
        private boolean secondItemReceived;
        private boolean thirdItemReceived;
        private boolean fourthItemReceived;
        private boolean fifthItemReceived;
        private boolean sixthItemReceived;
        private boolean hintUsed;


    public Speler(Status status) {
        this.status = status;
        items = new ArrayList<>();
        Komkommer komkommer = new Komkommer();
        items.add(komkommer);
        jokerReceived = false;
        firstItemReceived = false;
        secondItemReceived = false;
        thirdItemReceived = false;
        fourthItemReceived = false;
        fifthItemReceived = false;
        sixthItemReceived = false;
        hintUsed = false;
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
            return "Kamer: " + status.getPositie() + System.lineSeparator() +
                    "Score: " + getStatus().getScore() + System.lineSeparator() +
                    "Inventory: " + itemsToString()
                    ;
        }

        public String itemsToString () {
            StringBuilder sb = new StringBuilder();
            for (IUsableItem item : items) {
                sb.append(item.getName()).append(", ");
            }
            if (!sb.isEmpty()) {
                sb.setLength(sb.length() - 2); // Remove trailing comma and space
            }
            return sb.toString();
        }

    public void setJokerReceived(boolean jokerReceived) {
        this.jokerReceived = jokerReceived;
    }

    public void setFirstItemReceived(boolean firstItemReceived) {
        this.firstItemReceived = firstItemReceived;
    }

    public void setSecondItemReceived(boolean secondItemReceived) {
        this.secondItemReceived = secondItemReceived;
    }

    public void setThirdItemReceived(boolean thirdItemReceived) {
        this.thirdItemReceived = thirdItemReceived;
    }

    public void setFourthItemReceived(boolean fourthItemReceived) {
        this.fourthItemReceived = fourthItemReceived;
    }

    public void setFifthItemReceived(boolean fifthItemReceived) {
        this.fifthItemReceived = fifthItemReceived;
    }

    public void setSixthItemReceived(boolean sixthItemReceived) {
        this.sixthItemReceived = sixthItemReceived;
    }

    public void setHintUsed(boolean hintUsed) {
        this.hintUsed = hintUsed;
    }

    public boolean isJokerReceived() {
        return jokerReceived;
    }

    public boolean isFirstItemReceived() {
        return firstItemReceived;
    }

    public boolean isSecondItemReceived() {
        return secondItemReceived;
    }

    public boolean isThirdItemReceived() {
        return thirdItemReceived;
    }

    public boolean isFourthItemReceived() {
        return fourthItemReceived;
    }

    public boolean isFifthItemReceived() {
        return fifthItemReceived;
    }

    public boolean isSixthItemReceived() {
        return sixthItemReceived;
    }

    public boolean isHintUsed() {
        return hintUsed;
    }
}
