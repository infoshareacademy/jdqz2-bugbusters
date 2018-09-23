package com.infoshare.bug_busters.shipping;

import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShippingDataGeneratorTest {  // napisac testy jednostkowe czyli do kazdej metody w tej klasie

    @Test
    public void createsCorrectHouseNumber() throws IOException {
        RandomDataGenerator generatorMock = mock(RandomDataGenerator.class);

        when(generatorMock.prepareHouseNumber()).thenReturn(7);

        ShippingDataGenerator underTest = new ShippingDataGenerator(generatorMock);

        ShippingData result = underTest.prepareShippingData();

        Assertions.assertThat(result.getHouseNumber()).isEqualTo(7);
    }
}
