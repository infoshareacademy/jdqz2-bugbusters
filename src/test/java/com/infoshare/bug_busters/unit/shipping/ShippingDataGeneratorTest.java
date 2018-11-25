package com.infoshare.bug_busters.unit.shipping;

import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.shipping.ShippingData;
import com.infoshare.bug_busters.shipping.ShippingDataGenerator;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShippingDataGeneratorTest {  // napisac testy jednostkowe czyli do kazdej metody w tej klasie

    @Test
    public void createsCorrectHouseNumber() throws IOException {    // testy jednostkowe
        RandomDataGenerator generatorMock = mock(RandomDataGenerator.class);
        when(generatorMock.prepareHouseNumber()).thenReturn("7");
        ShippingDataGenerator underTest = new ShippingDataGenerator(generatorMock);
        ShippingData result = underTest.prepareShippingData();
        Assertions.assertThat(result.getHouseNumber()).isEqualTo("7");
    }

    @Test
    public void createsCorrectStreetName() throws IOException {
        RandomDataGenerator generatorMock = mock(RandomDataGenerator.class);
        when(generatorMock.prepareStreetName()).thenReturn("Wesola");
        ShippingDataGenerator underTest = new ShippingDataGenerator(generatorMock);
        ShippingData result = underTest.prepareShippingData();
        Assertions.assertThat(result.getStreetName()).isEqualTo("Wesola");
    }

    @Test
    public void createsCorrectCity() throws IOException {
        RandomDataGenerator generatorMock = mock(RandomDataGenerator.class);
        when(generatorMock.prepareCity()).thenReturn("New York");
        ShippingDataGenerator underTest = new ShippingDataGenerator(generatorMock);
        ShippingData result = underTest.prepareShippingData();
        Assertions.assertThat(result.getCity()).isEqualTo("New York");
    }

    @Test
    public void createsCorrectPostCode() throws IOException {
        RandomDataGenerator generatorMock = mock(RandomDataGenerator.class);
        when(generatorMock.preparePostCode()).thenReturn("12345");
        ShippingDataGenerator underTest = new ShippingDataGenerator(generatorMock);
        ShippingData result = underTest.prepareShippingData();
        Assertions.assertThat(result.getPostCode()).isEqualTo("12345");
    }

    @Test
    public void createsCorrectCountry() throws IOException {
        RandomDataGenerator generatorMock = mock(RandomDataGenerator.class);
        when(generatorMock.prepareCountry()).thenReturn("Poland");
        ShippingDataGenerator underTest = new ShippingDataGenerator(generatorMock);
        ShippingData result = underTest.prepareShippingData();
        Assertions.assertThat(result.getCountry()).isEqualTo("Poland");
    }
}
