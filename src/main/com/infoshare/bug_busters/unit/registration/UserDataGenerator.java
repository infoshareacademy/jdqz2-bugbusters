package com.infoshare.bug_busters.unit.registration;
import com.infoshare.bug_busters.unit.random.RandomDataGenerator;

import java.io.IOException;

public class UserDataGenerator {

    private final RandomDataGenerator dataGenerator;

    public UserDataGenerator(RandomDataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }


    public UserData prepareUserData() throws IOException {
        String userName = dataGenerator.prepareUserName();
        String firstName = dataGenerator.prepareFirstName();
        String lastName = dataGenerator.prepareLastName() ;
        String email = dataGenerator.prepareEmail();
        String password = dataGenerator.preparePassword();

       return new UserData(userName,firstName,lastName,email,password);
    }



}
