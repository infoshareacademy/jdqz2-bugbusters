package com.infoshare.bug_busters.shipping;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ShippingData {

    @XmlAttribute(name = "houseNumber")
    Integer houseNumber;
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

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ShippingData(Integer houseNumber, String streetName, String city, String postCode, String country) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return "ShippingData{" +
                "houseNumber=" + houseNumber +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
