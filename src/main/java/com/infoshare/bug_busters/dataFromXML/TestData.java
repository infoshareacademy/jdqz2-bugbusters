package com.infoshare.bug_busters.dataFromXML;

import com.infoshare.bug_busters.payment.PaymentData;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.shipping.ShippingData;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="testData")
public class TestData  {

    @XmlElement(name="userData")
    List<UserData> userData;
    @XmlElement(name = "shippingData")
    List<ShippingData> shippingData;
    @XmlElement(name="paymentData")
    List<PaymentData> paymentData;

    public List<UserData> getUserData() {
        return userData;
    }
    public List<ShippingData> getShippingData() {return shippingData;}
    public List<PaymentData> getPaymentData() {return paymentData; }

}
