package com.infoshare.bug_busters.registration;
import com.infoshare.bug_busters.dataFromXML.TestData;

import com.infoshare.bug_busters.random.DdtDataGenerator;
import com.infoshare.bug_busters.random.RandomDataGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.xml.bind.JAXBContext.newInstance;

public class UserDataGenerator {


    private static Logger logger = LoggerFactory.getLogger(UserDataGenerator.class);
    private final RandomDataGenerator dataGenerator; // wyciagniety RandomDataGenerator na potrzeby mocka

    public UserDataGenerator(RandomDataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }
    //konstruktor ktory trzeba stworzyc z polem dataGenerator typu RandomDataGenerator, zeby w metodzie prepareUserData() nie bylo
                // na sztywno RandomDataGenerator.prepareUserName()

    public UserData prepareUserData() {

        String userName = null;
        String firstName = null;
        String lastName = null;
        String email = null;
        String password = null;

        try {
            userName = dataGenerator.prepareUserName();
            firstName = dataGenerator.prepareFirstName();
            lastName = dataGenerator.prepareLastName();
            email = dataGenerator.prepareEmail();
            password = dataGenerator.preparePassword();

        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return new UserData(userName, firstName, lastName, email, password);
    }

    public List<UserData> collectionOfUsers() throws IOException {

        Integer iloscDanych = 10;

        List<UserData> userData = new ArrayList<>();

        for (int i = 1; i <= iloscDanych; i++) {
            userData.add(prepareUserData());
        }

        return userData;
    }

}
