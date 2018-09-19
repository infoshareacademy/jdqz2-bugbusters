package com.infoshare.bug_busters.random;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class RandomDataGenerator {

    public String prepareUserName() throws IOException {

        String randomUserName = choiceRandomDataFromTextFile(0);

        return randomUserName;
    }

    public static String prepareFirstName() throws IOException {
        String randomFirstName = choiceRandomDataFromTextFile(1);
        return randomFirstName;
    }

    public static String prepareLastName() throws IOException {
        String randomLastName = choiceRandomDataFromTextFile(2);
        return randomLastName;
    }

    public static String prepareEmail() throws IOException {
        String randomEmail = choiceRandomDataFromTextFile(3);
        return randomEmail;

    }

    public static String preparePassword() throws IOException {
        String randomPassword = choiceRandomDataFromTextFile(4);
        return randomPassword;

    }

    public static Integer prepareHouseNumber() throws IOException {
        String randomHouseNumber = choiceRandomDataFromTextFile(5);
        return Integer.valueOf(randomHouseNumber);
    }

    public static String prepareStreetName() throws IOException {
        String randomStreetName = choiceRandomDataFromTextFile(6);
        return randomStreetName;
    }

    public static String prepareCity() throws IOException {
        String randomCity = choiceRandomDataFromTextFile(7);
        return randomCity;
    }

    public static String preparePostCode() throws IOException {
        String randomPostCode = choiceRandomDataFromTextFile(8);
        return randomPostCode;
    }

    public static String prepareCountry() throws IOException {
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

        //Zatwierdzenie typów oraz wykorzystanie Random
        String numerkarty = "";
        Integer Liczba;
        Random random = new Random();

        //Dodawanie kolejnych liczb do numeru karty ... lepiej niż losowac mega dużą liczbe, po drugie bałem się że liczba przekroczy granice 32bitów
        for (int i = 0; i < 16; i++) {
            Liczba = random.nextInt(9);
            numerkarty = numerkarty + Liczba.toString();
        }
        return numerkarty;
    }

    public static String Expires() {

        //wykorzystanie metody Random
        Random losowanie = new Random();

        //Wyznaczenie granic losowania, integer rok jest wpisany taki ... bo tak. Do zmiany najprawdopodobniej !!!
        Integer miesiac = losowanie.nextInt(11) + 1;
        Integer rok = losowanie.nextInt(30);

        //Format Daty ma ../.. więc zabezpieczyłem go przed przypadkowym przycinaniem cyfr
        if (miesiac < 10 && rok < 10) {
            return "0" + miesiac + "/" + "0" + rok;
        }
        if (miesiac < 10) {
            return "0" + miesiac + "/" + rok;
        }
        if (rok < 10) {
            return miesiac + "/" + "0" + rok;
        }
        return miesiac + "/" + rok;
    }

    public static String RandomCCV() {

        //dodanie metody Random
        Random generator = new Random();

        //tak to napisane zostało bo kod CCV msui być 3 cyfrowy
        Integer ccv = generator.nextInt(899) + 100;

        //Sprytne zamienienie na Stringa, bez "" nie działa
        return "" + ccv;
    }

}

//*************************************************************************************