package payment;

import java.util.Random;

public class Expires {
    public String losowanieWygasania(boolean czyMaLosowac){
        Random losowanie =new Random();
        Integer miesiac = losowanie.nextInt(11)+1;
        Integer rok = losowanie.nextInt(30);
        if(miesiac<10&&rok<10){
            return "0"+miesiac+"/"+"0"+rok;
        }
        if(miesiac<10){
            return "0"+miesiac+"/"+rok;
        }
        if(rok<10){
            return miesiac+"/"+"0"+rok;
        }
        return miesiac+"/"+rok;
    }
}
