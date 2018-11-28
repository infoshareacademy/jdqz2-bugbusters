

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.bug_busters.dataFromJson.ListOfDataToTests;
import com.infoshare.bug_busters.dataFromJson.DataToTestFromJson;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.shipping.ShippingData;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

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


       /* ObjectMapper mapper = new ObjectMapper();

        UserData user = new UserData("asdf", "Jan", "Kowalski", "asdf@wp.pl", "qwer");

        System.out.println(mapper.writeValueAsString(user));*/


       // dokleic gdzies do generowania userName + UUID.randomUUID().toString()

    }
}
