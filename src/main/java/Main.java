

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.bug_busters.dataFromJson.ListOfDataToTests;
import com.infoshare.bug_busters.dataFromJson.DataToTestCaseEntry;

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

        ObjectMapper mapper = new ObjectMapper();

        ListOfDataToTests allData = mapper.readValue(new File("testData.json"), ListOfDataToTests.class);

        //System.out.println(allData);

        for (DataToTestCaseEntry data : allData.getTests()) {
            System.out.println(data.getUser());
        }





       /* ObjectMapper mapper = new ObjectMapper();

        UserData user = new UserData("asdf", "Jan", "Kowalski", "asdf@wp.pl", "qwer");

        System.out.println(mapper.writeValueAsString(user));*/


       // dokleic gdzies do generowania userName + UUID.randomUUID().toString()

    }
}
