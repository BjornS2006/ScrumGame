package UsableItems;

public abstract class UsableItem implements I_UsebleItem{
    private String name;
    private String description;

    public UsableItem(String name, String description) {
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