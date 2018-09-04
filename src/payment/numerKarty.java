package payment;

import java.util.Random;

public class numerKarty {
    public String losowanieKarty(boolean czyMaLosowac){
        String numerkarty="";
        Integer Liczba;
        Random random = new Random();
        for(int i =0;i<16;i++){
            Liczba=random.nextInt(9);
            numerkarty=numerkarty+Liczba.toString();
        }
        return numerkarty;
    }
}
