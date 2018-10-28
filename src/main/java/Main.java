
import com.infoshare.bug_busters.TestData;
import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import com.infoshare.bug_busters.shipping.ShippingData;
import com.infoshare.bug_busters.shipping.ShippingDataGenerator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, JAXBException {
        UserDataGenerator userDataGenerator = new UserDataGenerator(new RandomDataGenerator());

       System.out.println(userDataGenerator.prepareUserData().toString());

       System.out.println(ShippingDataGenerator.prepareShippingData().toString());


        TestData testData = userDataGenerator.getDataFromXml();


        List<UserData> userData = testData.getUserData();
        List<ShippingData> shippingData= testData.getShippingData();

        RandomDataGenerator randomDataGenerator = new RandomDataGenerator();


        Integer randomIndex = randomDataGenerator.getRandomNumber(0, userData.size()-1);


        UserData data = userData.get(randomIndex);

        System.out.println(data);



        }
}
