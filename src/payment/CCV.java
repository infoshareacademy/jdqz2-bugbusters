package payment;

import java.util.Random;

public class CCV {
    public Integer losowanie(boolean czyMaLosowac){
        Random generator = new Random();
        int ccv = generator.nextInt(899)+100;
        return ccv;
    }

}
