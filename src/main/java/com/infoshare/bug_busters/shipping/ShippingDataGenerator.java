package com.infoshare.bug_busters.shipping;


import com.infoshare.bug_busters.random.RandomDataGenerator;

import java.io.IOException;

public class ShippingDataGenerator {

    private final RandomDataGenerator dataGenerator; // wyciagniety RandomDataGenerator na potrzeby mocka

    public ShippingDataGenerator(RandomDataGenerator dataGenerator) { // konstruktor z wstrzyknieta klasa RandomDataGenerator??? co tu sie dziej
        this.dataGenerator = dataGenerator;
        //dependency enjection
    }

    public ShippingData prepareShippingData() throws IOException {

        String houseNumber = dataGenerator.prepareHouseNumber();
        String streetName = dataGenerator.prepareStreetName();
        String city = dataGenerator.prepareCity() ;
        String postCode = dataGenerator.preparePostCode();
        String country = dataGenerator.prepareCountry();

        return new ShippingData(houseNumber, streetName, city, postCode, country);
    }

    // stworzyc liste z paroma obiektami ShippingData, ilosc obiektow bedzie podawana przez uzytkownika
}

