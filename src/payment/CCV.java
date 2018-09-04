package payment;

import java.util.Random;

public class CCV {
    public String losowanie(boolean czyMaLosowac){
        Random generator = new Random();
        Integer ccv = generator.nextInt(899)+100;
        return ""+ccv;
    }

}
