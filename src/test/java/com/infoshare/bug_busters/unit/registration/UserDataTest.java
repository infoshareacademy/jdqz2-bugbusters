package com.infoshare.bug_busters.unit.registration;

import com.infoshare.bug_busters.random.RandomDataGenerator;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.registration.UserDataGenerator;
import org.junit.Test;

import java.io.IOException;
import java.util.regex.Pattern;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserDataTest {  // napisac testy jednostkowe czyli do kazdej metody w tej klasie


    UserDataGenerator userdataGeneratoApp = new UserDataGenerator(new RandomDataGenerator());

    @Test
    public void checkifisnotnull() throws IOException {
        UserData checkingValuesNotNull = userdataGeneratoApp.prepareUserData();


        assertNotNull( "Username is not null",checkingValuesNotNull.getUserName());
        assertNotNull( "FirstName is not null",checkingValuesNotNull.getFirstName());
        assertNotNull( "LastName is not null",checkingValuesNotNull.getLastName());
        assertNotNull( "Email is not null",checkingValuesNotNull.getEmail());
        assertNotNull( "Password is not null",checkingValuesNotNull.getPassword());

    }







}
