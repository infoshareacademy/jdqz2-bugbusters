package com.infoshare.bug_busters.registration;

import java.util.Random;

public class UserData {

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

    public String userName;
    public String firstName;
    public String lastName;
    public String email;
    public String password;

    public UserData(String userName, String firstName, String lastName, String email, String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;

        //return new UserData(userName,firstName,lastName,email,password);


    }
}

}
