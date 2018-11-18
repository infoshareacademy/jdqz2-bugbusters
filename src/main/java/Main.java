

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.bug_busters.pageObject.HomePage;
import com.infoshare.bug_busters.payment.PaymentDataGenerator;
import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import com.infoshare.bug_busters.shipping.ShippingDataGenerator;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        /*UserDataGenerator userDataGenerator = new UserDataGenerator(new RandomDataGenerator());

        ShippingDataGenerator shippingDataGenerator = new ShippingDataGenerator(new RandomDataGenerator());

        PaymentDataGenerator paymentDataGenerator = new PaymentDataGenerator(new RandomDataGenerator());

        //do prezentacji : listy obiektow, uzytkownik decyduje ile obiektow chce otrzymac

        System.out.println(paymentDataGenerator.preparePayments());

        System.out.println(userDataGenerator.prepareUserData());

        System.out.println(shippingDataGenerator.createListWithObjectsWithRandomChoiceDate(1 ));*/

        // https://www.baeldung.com/jackson-object-mapper-tutorial

    }
}
