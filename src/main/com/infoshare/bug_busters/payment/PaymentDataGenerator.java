package com.infoshare.bug_busters.payment;

import com.infoshare.bug_busters.random.RandomDataGenerator;
import java.util.ArrayList;
import java.util.List;

public class PaymentDataGenerator {

    //Główna metoda zwracająca losowe dane
    public PaymentData preparePayments() {

        //najprawdopodobnie niepotrzebne boolean ale zostawiam
        String CardRandomString = RandomDataGenerator.CardNumberRandom();
        String CardExpiresString = RandomDataGenerator.Expires();
        String randomCCVString = RandomDataGenerator.RandomCCV();

        //Co i jak ma zwracać
        return new PaymentData(CardRandomString, CardExpiresString, randomCCVString);

    }

    public List<PaymentData> safeToCollection() {

        //Stworzenie Skaneru do pobrania ile danych ma być wyplutych
        Integer iloscDanych = 10;

        //Kolekcja która przetrzymuje te dane
        List<PaymentData> paymentsData = new ArrayList<>();

        //pentla w której wykorzystujemy metode z ListPayment
        for (int i = 1; i <= iloscDanych; i++) {

            paymentsData.add(preparePayments());

        }
        return paymentsData;
    }

}
