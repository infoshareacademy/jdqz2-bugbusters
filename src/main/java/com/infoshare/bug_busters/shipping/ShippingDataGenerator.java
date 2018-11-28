package com.infoshare.bug_busters.shipping;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.bug_busters.dataFromJson.ListOfDataToTests;
import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShippingDataGenerator {

    private final RandomDataGenerator dataGenerator;

    public ShippingDataGenerator(RandomDataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }

    ShippingData oneShippingAddress;
    Random random = new Random();
    ObjectMapper mapper = new ObjectMapper();

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

    public ShippingData randomOneShippingAddressFromJson() {

        try {

            ListOfDataToTests allData = mapper.readValue(new File("testData.json"), ListOfDataToTests.class);

            oneShippingAddress = allData.getTestsData()
                    .get(random.nextInt(allData.getTestsData().size()))
                    .getAddress();

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return oneShippingAddress;
    }
}

