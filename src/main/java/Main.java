import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import com.infoshare.bug_busters.shipping.ShippingDataGenerator;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, JAXBException {
        UserDataGenerator userDataGenerator = new UserDataGenerator(new RandomDataGenerator());

        System.out.println(userDataGenerator.prepareUserData().toString());

        System.out.println(ShippingDataGenerator.prepareShippingData().toString());

        System.out.println(userDataGenerator.getDataFromXml());

    }
}
