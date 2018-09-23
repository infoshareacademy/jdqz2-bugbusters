package com.infoshare.bug_busters.shipping;

import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;
import java.util.regex.Pattern;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShippingDataGeneratorTest {  // napisac testy jednostkowe czyli do kazdej metody w tej klasie

    @Test
    public void createsCorrectHouseNumber() throws IOException {
        RandomDataGenerator generatorMock = mock(RandomDataGenerator.class);

        when(generatorMock.prepareHouseNumber()).thenReturn("7");

        ShippingDataGenerator underTest = new ShippingDataGenerator(generatorMock);

        ShippingData result = underTest.prepareShippingData();

        Assertions.assertThat(result.getHouseNumber()).isEqualTo("7");
    }



    //przez moki zmienil sie konstruktor w klasie ShippingDataGenerator
    RandomDataGenerator dataGenerator = new RandomDataGenerator();

    ShippingDataGenerator shippingDataGenerator = new ShippingDataGenerator(dataGenerator); //co daje takie tworzenie konstruktora???

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

}
