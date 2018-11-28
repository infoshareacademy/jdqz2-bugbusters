package com.infoshare.bug_busters.dataFromJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.shipping.ShippingData;

public class DataToTestFromJson {

    private UserData  user;
    private ShippingData address;

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public ShippingData getAddress() {
        return address;
    }

    public void setAddress(ShippingData address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "user=" + user +
                ", address=" + address;
    }
}
