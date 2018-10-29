package com.infoshare.bug_busters;

import com.infoshare.bug_busters.payment.PaymentData;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.shipping.ShippingData;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="TestData")
public class TestData  {

    @XmlElement(name="UserData")
    List<UserData> userData;
    @XmlElement(name = "ShippingData")
    List<ShippingData> shippingData;
    @XmlElement(name="PaymentData")
    List<PaymentData> paymentData;

    public List<UserData> getUserData() {
        return userData;
    }
    public List<ShippingData> getShippingData() {return shippingData;}
    public List<PaymentData> getPaymentData() {return paymentData; }

}
