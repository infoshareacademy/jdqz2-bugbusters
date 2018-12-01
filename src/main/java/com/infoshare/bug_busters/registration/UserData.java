package com.infoshare.bug_busters.registration;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.UUID;

@XmlRootElement
public class UserData {

    @XmlAttribute(name="userName")
    String userName;
    @XmlAttribute(name="firstName")
    String firstName;
    @XmlAttribute(name="lastName")
    String lastName;
    @XmlAttribute(name="email")
    String email;
    @XmlAttribute(name="password")
    String password;

    public UserData() {

    }

    public UserData(String userName, String firstName, String lastName, String email, String password) {
        this.userName = userName + UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getUserName() {
        return userName ;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
