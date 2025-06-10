// src/main/java/joker/JokerBase.java
package joker;

import kamers.Kamer;
import usableitems.IUsableItem;
import utils.SpelerSession;

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

    public final void useIn(Kamer kamer) {
        if (isUsed()) {
            System.out.println("Je hebt de " + getName() + " al gebruikt.");
            return;
        }
        if (canUseIn(kamer)) {
            doUseIn(kamer);
            markUsed();
        } else {
            System.out.println(getUsageRestrictionMessage());
        }
    }

    protected boolean canUseIn(Kamer kamer) {
        return true; // Default: always usable
    }

    protected String getUsageRestrictionMessage() {
        return "Deze joker kan hier niet gebruikt worden.";
    }

    protected abstract void doUseIn(Kamer kamer);
}