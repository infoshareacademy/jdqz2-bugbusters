import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import com.infoshare.bug_busters.shipping.ShippingData;
import com.infoshare.bug_busters.shipping.ShippingDataGenerator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        UserDataGenerator userDataGenerator = new UserDataGenerator(new RandomDataGenerator()); //po co tworze new RandomDataGenerator

        ShippingDataGenerator shippingDataGenerator = new ShippingDataGenerator(new RandomDataGenerator());


        System.out.println(userDataGenerator.prepareUserData().toString());

        System.out.println(shippingDataGenerator.prepareShippingData().toString());
    }
}
