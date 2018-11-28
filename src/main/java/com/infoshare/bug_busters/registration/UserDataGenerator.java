package com.infoshare.bug_busters.registration;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.bug_busters.dataFromJson.ListOfDataToTests;
import com.infoshare.bug_busters.random.RandomDataGenerator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserDataGenerator {

    private final RandomDataGenerator dataGenerator;

    public UserDataGenerator(RandomDataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }

    UserData oneUser;
    Random random = new Random();
    ObjectMapper mapper = new ObjectMapper();

    public UserData prepareUserData() throws IOException {

        String userName = dataGenerator.prepareUserName();
        String firstName = dataGenerator.prepareFirstName();
        String lastName = dataGenerator.prepareLastName();
        String email = dataGenerator.prepareEmail();
        String password = dataGenerator.preparePassword();

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

    public UserData randomOneUserFromJson() {

        try {

            ListOfDataToTests allData = mapper.readValue(new File("testData.json"), ListOfDataToTests.class);

            oneUser = allData.getTestsData()
                    .get(random.nextInt(allData.getTestsData().size()))
                    .getUser();

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return oneUser;
    }
}
