package com.infoshare.bug_busters.unit.registration;

import com.infoshare.bug_busters.unit.random.RandomDataGenerator;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserDataGeneratorTest {  // napisac testy jednostkowe czyli do kazdej metody w tej klasie
    @Test
    public void createsCorrectUser() throws IOException {
        RandomDataGenerator generatorMock = mock(RandomDataGenerator.class);

        when(generatorMock.prepareUserName()).thenReturn("ola_test");

        UserDataGenerator underTest = new UserDataGenerator(generatorMock);

        UserData result = underTest.prepareUserData();

        Assertions.assertThat(result.getUserName())
                .isEqualTo("ola_test");
    }
}
