package usableitems;

<<<<<<< HEAD:ScrumGame/src/main/java/UsableItems/UsableItem.java
public abstract class UsableItem implements I_UsableItem {
=======
public abstract class UsableItem implements IUsebleItem {
>>>>>>> Jokertest:ScrumGame/src/main/java/usableitems/UsableItem.java
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