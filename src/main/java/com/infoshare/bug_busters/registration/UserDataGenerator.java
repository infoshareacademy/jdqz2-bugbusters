package com.infoshare.bug_busters.registration;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.bug_busters.dataFromJson.ListOfDataToTests;
import com.infoshare.bug_busters.random.RandomDataGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserDataGenerator {

    private static Logger logger = LoggerFactory.getLogger(UserDataGenerator.class);
    private final RandomDataGenerator dataGenerator;
    UserData oneUser;
    Random random = new Random();
    ObjectMapper mapper = new ObjectMapper();

    public UserDataGenerator(RandomDataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }

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

    public UserData randomOneUserFromJson() {

        try {

            ListOfDataToTests allData = mapper.readValue(new File("testData.json"), ListOfDataToTests.class);

            oneUser = allData.getTestsData()
                    .get(random.nextInt(allData.getTestsData().size()))
                    .getUser();

        } catch (JsonGenerationException e) {
            logger.error(e.getMessage());
        } catch (JsonMappingException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return oneUser;
    }
}
