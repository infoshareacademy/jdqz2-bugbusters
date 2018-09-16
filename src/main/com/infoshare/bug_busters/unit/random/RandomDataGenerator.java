package com.infoshare.bug_busters.unit.random;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class RandomDataGenerator {

    public static String prepareUserName() throws IOException {
        //String userName[] = { "Karol", "Wojtek", "Dorota", "Marian", "Krzysiek", "Jan" }; //pierwsze podejscie z tablica

        String allUserNames = new String(Files.readAllLines(Paths.get("testData.txt")).get(0)); //get(0) - pobiera pierwsza linie

        String[] allUserNamesArray = allUserNames.split(",");

        String randomUserName = allUserNamesArray[new Random().nextInt(allUserNamesArray.length)];

        return randomUserName;
    }

    public static String prepareFirstName() throws IOException {
        String allFirstNames = new String(Files.readAllLines(Paths.get("testData.txt")).get(1));
        String[] allFirstNamesArray = allFirstNames.split(",");
        String randomFirstName = allFirstNamesArray[new Random().nextInt(allFirstNamesArray.length)];
        return randomFirstName;
    }

    public static  String prepareLastName() throws IOException {
        String allLastNames = new String(Files.readAllLines(Paths.get("testData.txt")).get(2));
        String[] allLastNamesArray = allLastNames.split(",");
        String randomLastName = allLastNamesArray[new Random().nextInt(allLastNamesArray.length)];
        return randomLastName;
    }

    public static  String prepareEmail () throws IOException {
        String allEmails = new String(Files.readAllLines(Paths.get("testData.txt")).get(3));
        String[] allEmailsArray = allEmails.split(",");
        String randomEmail = allEmailsArray[new Random().nextInt(allEmailsArray.length)];
        return randomEmail;

    }

    public static  String preparePassword() throws IOException {
        String allPasswords = new String(Files.readAllLines(Paths.get("testData.txt")).get(4));
        String[] allPasswordsArray = allPasswords.split(",");
        String randomPassword = allPasswordsArray[new Random().nextInt(allPasswordsArray.length)];
        return randomPassword;

    }

    public static Integer prepareHouseNumber() throws IOException {
        String allHouseNumbers = new String(Files.readAllLines(Paths.get("testData.txt")).get(5));
        String[] allHouseNumbersArray = allHouseNumbers.split(",");
        String randomHouseNumber = allHouseNumbersArray[new Random().nextInt(allHouseNumbersArray.length)];
        return Integer.valueOf(randomHouseNumber);
    }

    public static  String prepareStreetName() throws IOException {
        String allStreetNames = new String(Files.readAllLines(Paths.get("testData.txt")).get(6));
        String[] allStreetNamesArray = allStreetNames.split(",");
        String randomStreetName = allStreetNamesArray[new Random().nextInt(allStreetNamesArray.length)];
        return randomStreetName;
    }

    public static  String prepareCity() throws IOException {
        String allCitys = new String(Files.readAllLines(Paths.get("testData.txt")).get(7));
        String[] allCitysArray = allCitys.split(",");
        String randomCity = allCitysArray[new Random().nextInt(allCitysArray.length)];
        return randomCity;
    }

    public static  String preparePostCode() throws IOException {
        String allPostCodes = new String(Files.readAllLines(Paths.get("testData.txt")).get(8));
        String[] allPostCodesArray = allPostCodes.split(",");
        String randomPostCode = allPostCodesArray[new Random().nextInt(allPostCodesArray.length)];
        return randomPostCode;
    }

    public static  String prepareCountry() throws IOException {
        String allCountrys = new String(Files.readAllLines(Paths.get("testData.txt")).get(9));
        String[] allCountrysArray = allCountrys.split(",");
        String randomCountry = allCountrysArray[new Random().nextInt(allCountrysArray.length)];
        return randomCountry;
    }
}
