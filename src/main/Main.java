import com.infoshare.bug_busters.unit.registration.UserDataGenerator;
import com.infoshare.bug_busters.unit.shipping.ShippingDataGenerator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println(UserDataGenerator.prepareUserData().toString());

        System.out.println(ShippingDataGenerator.prepareShippingData().toString());
    }
}
