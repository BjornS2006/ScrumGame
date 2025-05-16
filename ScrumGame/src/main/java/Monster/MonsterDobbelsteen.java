package Monster;

import java.util.Random;

public class MonsterDobbelsteen implements MonsterActie {
        private int keuze;

        public void uitvoeren() {
            Random random = new Random();
            keuze = random.nextInt(2) + 1;
            System.out.println("De monster heeft zijn dobbelsteen gerold... Uitkomst: " + keuze);
        }

        public int getKeuze() {
            return keuze;
        }
    }
