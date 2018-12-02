
import com.infoshare.bug_busters.dataFromXML.TestData;
import com.infoshare.bug_busters.dataFromXML.TestDataGenerator;
import com.infoshare.bug_busters.payment.PaymentData;

import com.infoshare.bug_busters.payment.PaymentDataGenerator;
import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import com.infoshare.bug_busters.shipping.ShippingData;
import com.infoshare.bug_busters.shipping.ShippingDataGenerator;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, JAXBException {

        UserDataGenerator userDataGenerator = new UserDataGenerator(new RandomDataGenerator());

        ShippingDataGenerator shippingDataGenerator = new ShippingDataGenerator(new RandomDataGenerator());

        PaymentDataGenerator paymentDataGenerator = new PaymentDataGenerator();

        //do prezentacji : listy obiektow, uzytkownik decyduje ile obiektow chce otrzymac

        System.out.println(paymentDataGenerator.preparePayments());

        System.out.println(new ShippingDataGenerator(new RandomDataGenerator()).prepareShippingData().toString());

        TestData testData = new TestDataGenerator().getDataFromXml();
        List<UserData> userData = testData.getUserData();
        List<ShippingData> shippingData= testData.getShippingData();
        List<PaymentData> paymentData = testData.getPaymentData();
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        Integer randomIndexUD = randomDataGenerator.getRandomNumber(0, userData.size() - 1);
        Integer randomIndexSD = randomDataGenerator.getRandomNumber(0, shippingData.size() - 1);
        Integer randomIndexPD = randomDataGenerator.getRandomNumber(0,paymentData.size() -1);
        UserData userData1 = userData.get(randomIndexUD);
        ShippingData shippingData1 = shippingData.get(randomIndexSD);
        PaymentData paymentData1 = paymentData.get(randomIndexPD);
                System.out.println(userData1);
                System.out.println(shippingData1);
                System.out.println(paymentData1);


        System.out.println(userDataGenerator.prepareUserData());

        System.out.println(shippingDataGenerator.createListWithObjectsWithRandomChoiceDate(1 ));
    }
}
