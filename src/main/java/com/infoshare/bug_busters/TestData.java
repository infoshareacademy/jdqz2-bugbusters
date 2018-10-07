package com.infoshare.bug_busters;

import com.infoshare.bug_busters.payment.PaymentData;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.shipping.ShippingData;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestData {

    @XmlElement
    UserData userData;
    ShippingData shippingData;
    PaymentData paymentData;
}
