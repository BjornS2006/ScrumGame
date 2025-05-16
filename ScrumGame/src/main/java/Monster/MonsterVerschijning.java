package Monster;

public class MonsterVerschijning implements MonsterActie {
    private String naam;

    public MonsterVerschijning(String naam) {
        this.naam = naam;
    }

    @Override
    public void uitvoeren() {
        System.out.println("KIJK UIT, DE " + naam + " VERSCHIJNT!!");
    }
}