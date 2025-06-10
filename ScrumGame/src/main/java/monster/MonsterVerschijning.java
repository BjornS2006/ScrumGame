package monster;

public class MonsterVerschijning {
    private String naam;

    public MonsterVerschijning(String naam) {
        this.naam = naam;
    }

    public void uitvoeren() {
        System.out.println("KIJK UIT, DE " + naam.toUpperCase() + " VERSCHIJNT!!");
    }
}