package java.com.infoshare.bug_busters.unit.registration;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.com.infoshare.bug_busters.random.RandomDataGenerator;
import java.com.infoshare.bug_busters.registration.UserData;
import java.com.infoshare.bug_busters.registration.UserDataGenerator;
import java.io.IOException;
import java.util.Random;

import static javafx.beans.binding.Bindings.when;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UserDataGeneratorTest {  // napisac testy jednostkowe czyli do kazdej metody w tej klasie
    @Before
    //tutaj mozna wyciagnac tworzenie mocka 21 linijka

    @Test
    public void createsCorrectUserName() throws IOException {
        RandomDataGenerator generatorMock = mock(RandomDataGenerator.class); //tworzy moka z klasy RandomDataGenerator czyli ma dostep do pol i metod tej klasy

        when(generatorMock.prepareUserName()).thenReturn("login_ola"); //na moku wykonuje metode prepareUserName() z klasy RandomDataGenerator i mowie jej co ma zwocic
        //dzieki temu metoda prepareUserName() zwroci tylko "login_ola"

        UserDataGenerator underTest = new UserDataGenerator(generatorMock); // stworzenie nowego obiektu bedacego instancja klasy UserDataGenerator ktorej metoda jest testowana
        // tworzona z konstruktora klasy UserDataGenerator ale wstrzykuje do niego zmienna mock dzieki temu obchodze wywolanie prawdziwej klasy RandomDataGenerator

        UserData result = underTest.prepareUserData();

        Assertions.assertThat(result.getUserName()) //asercja assertJa
                .isEqualTo("login_ola");
    }

    @Test
    public void createsCorrectFirstName() throws IOException {
        RandomDataGenerator generatorMock = mock(RandomDataGenerator.class);
        when(generatorMock.prepareFirstName()).thenReturn("Karol"); // prepareFirstName to nie moze byc statyczna metoda bo wykona sie szybciej niz wstrzykniecie moka
        UserDataGenerator underTest = new UserDataGenerator(generatorMock);
        UserData result = underTest.prepareUserData();
        Assertions.assertThat(result.getFirstName()).isEqualTo("Karol");
    }

}
