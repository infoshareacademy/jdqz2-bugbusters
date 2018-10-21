package com.infoshare.bug_busters.shipping;

import com.infoshare.bug_busters.random.RandomDataGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShippingDataGenerator {

    private final RandomDataGenerator dataGenerator; // wyciagniety RandomDataGenerator na potrzeby mocka

    public ShippingDataGenerator(RandomDataGenerator dataGenerator) { // konstruktor z wstrzyknieta klasa RandomDataGenerator
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

    public List<ShippingData> createListWithObjectsWithRandomChoiceDate(int numberOfShippingDataObjects) throws IOException {

        List<ShippingData> shippingData = new ArrayList<>();

        for (int i = 1; i <= numberOfShippingDataObjects; i++) {
            shippingData.add(prepareShippingData());
        }
        return shippingData;
    }
}

