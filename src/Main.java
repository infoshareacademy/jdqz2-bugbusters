import shipping.ShippingData;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

//        String userName[] = { "Karol", "Wojtek", "Dorota", "Marian", "Krzysiek", "Jan" };
//        String randomName = userName[new Random().nextInt(userName.length)];
//        System.out.println(randomName);


        Integer houseNumber[] = {12, 22, 34, 55, 1};
        Integer randomHouseNumber = houseNumber[new Random().nextInt(houseNumber.length)];
//        System.out.println(randomHouseNumber);

        String streetName[] = {"Wesola", "Mickiewicza", "Chlopska", "Kolobrzeska", "Grunwaldzka"};
        String randomStreetName = streetName[new Random().nextInt(streetName.length)];
//        System.out.println(randomStreetName);

        String city[] = {"Gdansk", "Gdynia", "Sopot", "Rumia", "Wejherowo"};
        String randomCity = city[new Random().nextInt(city.length)];
//        System.out.println(randomCity);

        String postCode[] = {"80-399", "55-300", "34-350", "12-399", "90-999"};
        String randomPostCode = postCode[new Random().nextInt(postCode.length)];
//        System.out.println(randomPostCode);

        String country[] = {"Polska", "Wlochy", "Niemcy", "Litwa", "Czechy"};
        String randomCountry = country[new Random().nextInt(country.length)];
//        System.out.println(randomCountry);


        ShippingData shippingAddress = new ShippingData(randomHouseNumber, randomStreetName, randomCity, randomPostCode, randomCountry);

        System.out.println(shippingAddress.toString());

    }
}


