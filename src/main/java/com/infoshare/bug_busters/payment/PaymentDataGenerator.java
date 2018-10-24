package com.infoshare.bug_busters.payment;

import com.infoshare.bug_busters.TestData;
import com.infoshare.bug_busters.random.RandomDataGenerator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PaymentDataGenerator {

    public PaymentData preparePayments() {

        String CardRandomString = RandomDataGenerator.CardNumberRandom();
        String CardExpiresString = RandomDataGenerator.Expires();
        String randomCCVString = RandomDataGenerator.RandomCCV();

        return new PaymentData(CardRandomString, CardExpiresString, randomCCVString);

    }

    public List<PaymentData> safeToCollection() {

        Integer iloscDanych = 10;

        List<PaymentData> paymentsData = new ArrayList<>();

        for (int i = 1; i <= iloscDanych; i++) {
            paymentsData.add(preparePayments());
        }

        return paymentsData;

    }





    }
