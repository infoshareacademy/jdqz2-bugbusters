import com.infoshare.bug_busters.unit.random.RandomDataGenerator;
import com.infoshare.bug_busters.unit.registration.UserDataGenerator;
import com.infoshare.bug_busters.unit.shipping.ShippingDataGenerator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        UserDataGenerator userDataGenerator = new UserDataGenerator(new RandomDataGenerator());

        System.out.println(userDataGenerator.prepareUserData().toString());

        System.out.println(ShippingDataGenerator.prepareShippingData().toString());
    }
}
