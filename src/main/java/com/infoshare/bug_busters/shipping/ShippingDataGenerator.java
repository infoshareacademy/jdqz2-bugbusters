package com.infoshare.bug_busters.shipping;


import com.infoshare.bug_busters.random.RandomDataGenerator;

import java.io.IOException;

public class ShippingDataGenerator {


    public ShippingDataGenerator(RandomDataGenerator randomDataGenerator) {
    }

    public static ShippingData prepareShippingData() {

        Integer houseNumber = null;
        String streetName = null;
        String city = null;
        String postCode = null;
        String country = null;


        try {
            houseNumber = RandomDataGenerator.prepareHouseNumber();
            streetName = RandomDataGenerator.prepareStreetName();
            city = RandomDataGenerator.prepareCity();
            postCode = RandomDataGenerator.preparePostCode();
            country = RandomDataGenerator.prepareCountry();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ShippingData(houseNumber, streetName, city, postCode, country);
    }
}

