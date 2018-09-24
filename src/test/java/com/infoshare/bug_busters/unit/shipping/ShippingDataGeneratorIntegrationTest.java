package com.infoshare.bug_busters.unit.shipping;

import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.shipping.ShippingData;
import com.infoshare.bug_busters.shipping.ShippingDataGenerator;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static sun.awt.X11.XConstants.InputOutput;

public class ShippingDataGeneratorIntegrationTest {

    private RandomDataGenerator dataGenerator;
    private ShippingDataGenerator shippingDataGenerator;

    @Before
    public void getShippingDataGenerator() {
        dataGenerator = new RandomDataGenerator();
        shippingDataGenerator = new ShippingDataGenerator(dataGenerator); // == shippingDataGenerator = new ShippingDataGenerator(new RandomDataGenerator());
        //dependency enjection
    }

    @Test
    public void objectCreatedWithoutNullFields() throws IOException {

        ShippingData checkingValueNotNull = shippingDataGenerator.prepareShippingData();

        assertNotNull("House number is null", checkingValueNotNull.getHouseNumber());
        assertNotNull("Street is null", checkingValueNotNull.getStreetName());
        assertNotNull("City is null", checkingValueNotNull.getCity());
        assertNotNull("Post code is null", checkingValueNotNull.getPostCode());
        assertNotNull("Country is null", checkingValueNotNull.getCountry());
    }

    @Test
    public void validationOfCorrectnessObjectFieldCreated() throws IOException {

        ShippingData checkingCorrectnessOfData = shippingDataGenerator.prepareShippingData();

        assertTrue("It is not a number", Pattern.matches("\\d+", checkingCorrectnessOfData.getHouseNumber()));
        assertTrue("Street name contains numbers", Pattern.matches("\\D+", checkingCorrectnessOfData.getStreetName()));
        assertTrue("City name contains numbers", Pattern.matches("\\D+", checkingCorrectnessOfData.getCity()));
        assertTrue("Post does not have 5 digits", Pattern.matches("\\d{5}", checkingCorrectnessOfData.getPostCode()));
        assertTrue("Country name contains numbers", Pattern.matches("\\D+", checkingCorrectnessOfData.getCountry()));
    }

    @Test
    public void checkCorrectNumberOfObjectInList() throws IOException {

        Integer sizeOfList = shippingDataGenerator.createListWithObjectsWithRandomChoiceDate(5).size();

        assertEquals("List does not have 5 objects", "5", sizeOfList.toString());

    }
}
