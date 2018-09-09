package com.infoshare.bug_busters.registration;
import com.infoshare.bug_busters.random.RandomDataGenerator;

import java.util.ArrayList;
import java.util.List;

public class UserDataGenerator {


    public static UserData prepareUser() {
        String userName = RandomDataGenerator.prepareUserName(); //"Karol"
        String firstName = RandomDataGenerator.prepareFirstName();
        String lastName = RandomDataGenerator.prepareLastName() ;
        String email = RandomDataGenerator.prepareEmail();
        String password = RandomDataGenerator.preparePassword();

       return new UserData(userName,firstName,lastName,email,password);
    }

    public static List<UserData> prepareUsers(int listSize){

        List<UserData> users = new ArrayList<>();
        for (int i = 0; i < listSize; i++) ;
        UserDataGenerator.prepareUser();
        return users;
    }

}
