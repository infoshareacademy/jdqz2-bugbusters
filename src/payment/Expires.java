package payment;

import java.util.Random;

public class Expires {
    public String losowanieWygasania(boolean czyMaLosowac){

        //wykorzystanie metody Random
        Random losowanie =new Random();

        //Wyznaczenie granic losowania, integer rok jest wpisany taki ... bo tak. Do zmiany najprawdopodobniej !!!
        Integer miesiac = losowanie.nextInt(11)+1;
        Integer rok = losowanie.nextInt(30);

        //Format Daty ma ../.. więc zabezpieczyłem go przed przypadkowym przycinaniem cyfr
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
