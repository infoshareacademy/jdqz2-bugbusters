package com.infoshare.bug_busters.unit.registration;
import com.infoshare.bug_busters.unit.random.RandomDataGenerator;

import java.io.IOException;

public class UserDataGenerator {


    public static UserData prepareUserData() throws IOException {
        String userName = RandomDataGenerator.prepareUserName();
        String firstName = RandomDataGenerator.prepareFirstName();
        String lastName = RandomDataGenerator.prepareLastName() ;
        String email = RandomDataGenerator.prepareEmail();
        String password = RandomDataGenerator.preparePassword();

       return new UserData(userName,firstName,lastName,email,password);
    }



}
