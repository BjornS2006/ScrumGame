package monster;

import java.util.Random;

public class MonsterDobbelsteen implements MonsterActie {
        private int keuze;
        private Random random = new Random();

        public void uitvoeren() {
            keuze = random.nextInt(2) + 1;
            System.out.println("De monster heeft zijn dobbelsteen gerold... Uitkomst: " + keuze);
        }

        public int getKeuze() {
            return keuze;
        }
    }
