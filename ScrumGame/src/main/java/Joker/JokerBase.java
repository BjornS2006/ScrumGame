package Joker;

public abstract class JokerBase {
    private boolean used = false;

    public boolean isUsed() {
        return used;
    }

    protected void markUsed() {
        used = true;
    }
}

