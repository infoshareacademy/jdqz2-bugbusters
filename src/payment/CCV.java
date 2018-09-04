package payment;

import java.util.Random;

public class CCV {

    //stworzenie konstrukytora tak??
    public String losowanie(boolean czyMaLosowac){

        //dodanie metody Random
        Random generator = new Random();

        //tak to napisane zostało bo kod CCV msui być 3 cyfrowy
        Integer ccv = generator.nextInt(899)+100;

        //Sprytne zamienienie na Stringa, bez "" nie działa
        return ""+ccv;
    }

}
