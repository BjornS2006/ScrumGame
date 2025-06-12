package test;

import utils.SpelerSession;

public class checkAantalFouten {
    public boolean check(int fouten) {
        if (fouten >= 5 && fouten <= 100){
            return true;
        } else {
            return false;
        }
    }
}
