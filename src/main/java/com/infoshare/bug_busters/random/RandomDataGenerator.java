package com.infoshare.bug_busters.random;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Random;

public class RandomDataGenerator {
    private final Random randomGenerator;

    public RandomDataGenerator() {
        this.randomGenerator = new Random();
    }

    public Integer getRandomNumber(Integer from, Integer to) {
        return randomGenerator.nextInt(to) + from;
    }

    public String prepareUserName() throws IOException {

        String randomUserName = choiceRandomDataFromTextFile(0);

        return randomUserName;
    }

    public String prepareFirstName() throws IOException {
        String randomFirstName = choiceRandomDataFromTextFile(1);
        return randomFirstName;
    }

    public String prepareLastName() throws IOException {
        String randomLastName = choiceRandomDataFromTextFile(2);
        return randomLastName;
    }

    public String prepareEmail() throws IOException {
        String randomEmail = choiceRandomDataFromTextFile(3);
        return randomEmail;

    }

    public String preparePassword() throws IOException {
        String randomPassword = choiceRandomDataFromTextFile(4);
        return randomPassword;

    }

    public String prepareHouseNumber() throws IOException {
        String randomHouseNumber = choiceRandomDataFromTextFile(5);
        return randomHouseNumber;
    }

    public String prepareStreetName() throws IOException {
        String randomStreetName = choiceRandomDataFromTextFile(6);
        return randomStreetName;
    }

    public String prepareCity() throws IOException {
        String randomCity = choiceRandomDataFromTextFile(7);
        return randomCity;
    }

    public String preparePostCode() throws IOException {
        String randomPostCode = choiceRandomDataFromTextFile(8);
        return randomPostCode;
    }

    public String prepareCountry() throws IOException {
        String randomCountry = choiceRandomDataFromTextFile(9);
        return randomCountry;
    }

    private static String choiceRandomDataFromTextFile(int i) throws IOException {
        String allFirstNames = new String(Files.readAllLines(Paths.get("testData.txt")).get(i));
        String[] allFirstNamesArray = allFirstNames.split(",");
        return allFirstNamesArray[new Random().nextInt(allFirstNamesArray.length)];
    }


    //*************************************************************************************
    /*PaymentGenerator*////////////////////////////////////////////////////////////////////

    public static String CardNumberRandom() {

        String CardNumber = "";
        Integer Digital;
        Random random = new Random();

        for (int i = 0; i < 16; i++) {
            Digital = random.nextInt(9);
            CardNumber = CardNumber + Digital.toString();
        }
        return CardNumber;
    }

    public static String Expires() {

        Random random = new Random();

        Integer month = random.nextInt(11) + 1;
        Integer year = random.nextInt(30);

        if (month < 10 && year < 10) {
            return "0" + month + "/" + "0" + year;
        }
        if (month < 10) {
            return "0" + month + "/" + year;
        }
        if (year < 10) {
            return month + "/" + "0" + year;
        }
        return month + "/" + year;
    }

    public static String RandomCCV() {

        Random random = new Random();

        Integer ccv = random.nextInt(899) + 100;

        return "" + ccv;
    }

}

//*************************************************************************************