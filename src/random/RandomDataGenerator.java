package random;

import java.util.Random;

public class RandomDataGenerator {

    public static String prepareUserName() {
        String userName[] = { "Karol", "Wojtek", "Dorota", "Marian", "Krzysiek", "Jan" };
        String randomUserName = userName[new Random().nextInt(userName.length)];
        return randomUserName;
    }

    public static String prepareFirstName() {
        String[] firstName = {"Aneta", "Joanna", "Tomek", "WOjtek", "Czarek"};
        String randomfirstName = firstName[new Random().nextInt(firstName.length)];
        return randomfirstName;
    }

    public static  String prepareLastName() {
        String[] lastName = {"Aneta", "Joanna", "Tomek", "WOjtek", "Czarek"};
        String randomlastName = lastName[new Random().nextInt(lastName.length)];
        return randomlastName;
    }

    public static  String prepareEmail () {
        String[] email = {"test", "test1", "test2", "test3", "test4"};
        String randomEmail = email[new Random().nextInt(email.length)];
        return  randomEmail;
    }

    public static  String preparePassword() {
        String[] password = {"test", "test1", "test2", "test3", "test4"};
        String randompasssword = password[new Random().nextInt(password.length)];
        return randompasssword;
    }

    public static Integer prepareHouseNumber(){
        Integer houseNumber[] = {12, 22, 34, 55, 1};
        Integer randomHouseNumber = houseNumber[new Random().nextInt(houseNumber.length)];
        return randomHouseNumber;
    }

    public static  String prepareStreetName() {
        String streetName[] = {"Wesola", "Mickiewicza", "Chlopska", "Kolobrzeska", "Grunwaldzka"};
        String randomStreetName = streetName[new Random().nextInt(streetName.length)];
        return randomStreetName;
    }

    public static  String prepareCity() {
        String city[] = {"Gdansk", "Gdynia", "Sopot", "Rumia", "Wejherowo"};
        String randomCity = city[new Random().nextInt(city.length)];
        return randomCity;
    }

    public static  String preparePostCode() {
        String postCode[] = {"80-399", "55-300", "34-350", "12-399", "90-999"};
        String randomPostCode = postCode[new Random().nextInt(postCode.length)];
        return randomPostCode;
    }

    public static  String prepareCountry() {
        String country[] = {"Polska", "Wlochy", "Niemcy", "Litwa", "Czechy"};
        String randomCountry = country[new Random().nextInt(country.length)];
        return randomCountry
    }
}
