package com.infoshare.bug_busters;

import com.infoshare.bug_busters.payment.PaymentData;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.shipping.ShippingData;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestData {

    @XmlElement
    UserData userData;
    ShippingData shippingData;
    PaymentData paymentData;
    @XmlAttribute
    public String userName;
    public String getUserName(){return userName;}
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String firstName;
    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String lastName;
    public String getLastName(){return lastName;}
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String email;
    public String getEmail(){return email;}
    public void setEmail(String email) {
        this.email = email;
    }
    public String password;
    public String getPassword(){return password;}
    public void setPassword(String password) {
        this.password = password;
    }
    public String houseNumber;
    public String getHouseNumber(){return houseNumber;}
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
    public String streetName;
    public String getStreetName(){return streetName;}
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    public String city;
    public String getCity(){return city;}
    public void setCity(String city) {
        this.city = city;
    }
    public String postCode;
    public String getPostCode(){return postCode;}
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    public String country;
    public String getCountry(){return country;}
    public void setCountry(String country) {
        this.country = country;
    }
    public String cardNumber;
    public String getCardNumber(){return cardNumber;}
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String expires;
    public String getExpires(){return expires;}
    public void setExpires(String expires) {
        this.expires = expires;
    }
    public String ccv;
    public String getCcv(){return ccv;}
    public void setCcv(String ccv) {
        this.ccv = ccv;
    }


}
