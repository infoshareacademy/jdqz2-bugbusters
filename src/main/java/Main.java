
import com.infoshare.bug_busters.TestData;
import com.infoshare.bug_busters.payment.PaymentData;
import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import com.infoshare.bug_busters.shipping.ShippingData;
import com.infoshare.bug_busters.shipping.ShippingDataGenerator;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {

    public static void main(String[] args) throws IOException, JAXBException {
        UserDataGenerator userDataGenerator = new UserDataGenerator(new RandomDataGenerator());

        System.out.println(userDataGenerator.prepareUserData().toString());

        System.out.println(ShippingDataGenerator.prepareShippingData().toString());

        TestData testData = userDataGenerator.getDataFromXml();
        List<UserData> userData = testData.getUserData();
        List<ShippingData> shippingData= testData.getShippingData();
        List<PaymentData> paymentData = testData.getPaymentData();
        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();
        Integer randomIndex = randomDataGenerator.getRandomNumber(0, userData.size() - 1);
        Integer randomIndex1 = randomDataGenerator.getRandomNumber(0, shippingData.size() - 1);
        Integer randomIndex2 = randomDataGenerator.getRandomNumber(0,paymentData.size() -1);
        UserData userData1 = userData.get(randomIndex);
        ShippingData shippingData1 = shippingData.get(randomIndex1);
        PaymentData paymentData1 = paymentData.get(randomIndex2);
                System.out.println(userData1);
                System.out.println(shippingData1);
                System.out.println(paymentData1);


    }
}
