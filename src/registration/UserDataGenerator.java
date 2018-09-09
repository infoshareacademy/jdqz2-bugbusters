package registration;
import random.RandomDataGenerator;

public class UserDataGenerator {


    private static UserData prepareUser() {
        String userName = RandomDataGenerator.prepareUserName(); //"Karol"
        String firstName = RandomDataGenerator.prepareFirstName();
        String lastName = RandomDataGenerator.prepareLastName() ;
        String email = RandomDataGenerator.prepareEmail();
        String password = RandomDataGenerator.preparePassword();

       return new UserData(userName,firstName,lastName,email,password);
    }



}
