package joker;

import usableitems.IUsableItem;

import static joker.JokerHandler.handleJokerUsage;

public abstract class JokerBase implements IUsableItem {
    private boolean used = false;

    public boolean isUsed() {
        return used;
    }

    protected void markUsed() {
        used = true;
    }
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String getDescription() {
        return "Een joker die gebruikt kan worden in het spel.";
    }

    @Override
    public void gebruik() {
        handleJokerUsage();
    }
}

