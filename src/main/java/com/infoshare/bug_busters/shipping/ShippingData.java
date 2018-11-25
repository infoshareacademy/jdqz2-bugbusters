package com.infoshare.bug_busters.shipping;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ShippingData {

    @XmlAttribute(name = "houseNumber")
    String houseNumber;
    @XmlAttribute(name="streetName")
    String streetName;
    @XmlAttribute(name="city")
    String city;
    @XmlAttribute(name="postCode")
    String postCode;
    @XmlAttribute(name="country")
    String country;

    public ShippingData() {
    }

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
