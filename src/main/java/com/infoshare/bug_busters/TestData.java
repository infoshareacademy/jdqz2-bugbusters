package com.infoshare.bug_busters;

import com.infoshare.bug_busters.payment.PaymentData;
import com.infoshare.bug_busters.registration.UserData;
import com.infoshare.bug_busters.shipping.ShippingData;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class TestData {

    @XmlElement
    List<UserData> userData;
    @XmlElement
    List<ShippingData> shippingData;
    @XmlElement
    List<PaymentData> paymentData;




}
