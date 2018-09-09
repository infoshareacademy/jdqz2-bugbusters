package shipping;


public class ShippingDataGenerator {

    private static ShippingData prepareShippingData() {


        Integer HouseNumber = Ra
        String firstName = RandomDataGenerator.prepareFirstName();
        String lastName = RandomDataGenerator.prepareLastName() ;
        String email = RandomDataGenerator.prepareEmail();
        String password = RandomDataGenerator.preparePassword();

        return new UserData(userName,firstName,lastName,email,password);
    }





    ShippingData shippingAddress = new ShippingData(randomHouseNumber, randomStreetName, randomCity, randomPostCode, randomCountry);

}

