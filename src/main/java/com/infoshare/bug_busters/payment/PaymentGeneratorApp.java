package main.java.com.infoshare.bug_busters.payment;

import main.java.com.infoshare.bug_busters.payment.ListPayment;

import java.util.ArrayList;
import java.util.List;

public class PaymentGeneratorApp {
        public static void main(String[] args) {

            //Stworzenie Skaneru do pobrania ile danych ma być wyplutych
        Integer iloscDanych=10;


        //Kolekcja która przetrzymuje te dane
        List<ListPayment> paymentsData = new ArrayList<>();

        //pentla w której wykorzystujemy metode z ListPayment
        for(int i=1;i<=iloscDanych;i++){

            paymentsData.add(ListPayment.preparePayments());
            System.out.println(ListPayment.preparePayments());

            System.out.println("..............................");

        }


    }

}
