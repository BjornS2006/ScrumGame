package test;

public class checkAantalKamers {
    public boolean check(int kamerNummer) {
        if (kamerNummer >= 1 && kamerNummer <= 6){
            return true;
        } else {
            return false;
        }
    }
}
