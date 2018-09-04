package payment;

import java.util.Random;

public class numerKarty {
    public String losowanieKarty(boolean czyMaLosowac){

        //Zatwierdzenie typów oraz wykorzystanie Random
        String numerkarty="";
        Integer Liczba;
        Random random = new Random();

        //Dodawanie kolejnych liczb do numeru karty ... lepiej niż losowac mega dużą liczbe, po drugie bałem się że liczba przekroczy granice 32bitów
        for(int i =0;i<16;i++){
            Liczba=random.nextInt(9);
            numerkarty=numerkarty+Liczba.toString();
        }
        return numerkarty;
    }
}
