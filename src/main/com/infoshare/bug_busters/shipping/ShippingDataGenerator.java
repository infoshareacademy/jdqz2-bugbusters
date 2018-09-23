package com.infoshare.bug_busters.shipping;


import com.infoshare.bug_busters.random.RandomDataGenerator;

import java.io.IOException;

public class ShippingDataGenerator {

    private final RandomDataGenerator dataGenerator; // wyciagniety RandomDataGenerator na potrzeby mocka

    public ShippingDataGenerator(RandomDataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }

    public ShippingData prepareShippingData() throws IOException {

        Integer houseNumber = dataGenerator.prepareHouseNumber();
        String streetName = dataGenerator.prepareStreetName();
        String city = dataGenerator.prepareCity() ;
        String postCode = dataGenerator.preparePostCode();
        String country = dataGenerator.prepareCountry();

        return new ShippingData(houseNumber, streetName, city, postCode, country);
    }
}

