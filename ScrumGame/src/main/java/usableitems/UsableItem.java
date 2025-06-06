package usableitems;

public abstract class UsableItem implements IUsableItem {
    private String name;
    private String description;

    protected UsableItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }
    public String getDescription() {
        return description;
    }

}