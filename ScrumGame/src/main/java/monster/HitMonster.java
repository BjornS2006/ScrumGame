package monster;

import java.util.Random;

public class HitMonster {
    public boolean probeerMonsterHit() {
        Random rand = new Random();
        return rand.nextBoolean();
    }
}
