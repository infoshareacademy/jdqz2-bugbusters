package main.java.com.infoshare.bug_busters.payment;

import com.infoshare.bug_busters.random.RandomDataGenerator;
import main.java.com.infoshare.bug_busters.payment.ListPayment;

import java.util.ArrayList;
import java.util.List;

public class PaymentGeneratorApp {

    //Główna metoda zwracająca losowe dane
    public static ListPayment preparePayments() {

        //najprawdopodobnie niepotrzebne boolean ale zostawiam
        String CardRandomString = RandomDataGenerator.CardNumberRandom();
        String CardExpiresString = RandomDataGenerator.Expires();
        String randomCCVString = RandomDataGenerator.RandomCCV();

        //Co i jak ma zwracać
        return new ListPayment(CardRandomString, CardExpiresString, randomCCVString);

    }

    public static void safeToCollection() {

        //Stworzenie Skaneru do pobrania ile danych ma być wyplutych
        Integer iloscDanych = 10;

        //Kolekcja która przetrzymuje te dane
        List<ListPayment> paymentsData = new ArrayList<>();

        //pentla w której wykorzystujemy metode z ListPayment
        for (int i = 1; i <= iloscDanych; i++) {

            paymentsData.add(preparePayments());

        }

    }

}
