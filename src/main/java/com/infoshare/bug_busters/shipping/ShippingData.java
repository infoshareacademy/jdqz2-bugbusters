package com.infoshare.bug_busters.shipping;

public class ShippingData {

    private String houseNumber;
    private String streetName;
    private String city;
    private String postCode;
    private String country;

    public ShippingData(String houseNumber, String streetName, String city, String postCode, String country) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "ShippingData{" +
                "houseNumber='" + houseNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                '}' + "\n";
    }
}
