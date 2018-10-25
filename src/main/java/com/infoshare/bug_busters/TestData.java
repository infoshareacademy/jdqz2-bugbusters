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
//    @XmlElement(name = "ShippingData")
//    List<ShippingData> shippingData;
//    @XmlElement
//    List<PaymentData> paymentData;

    public List<UserData> getUserData() {
        return userData;
    }
//
//public List<ShippingData> getShippingData() {
//return shippingData;}
//    }
//
//    public List<PaymentData> getPaymentData() {
//        return paymentData;
//    }
//
//    public void setUserData(List<UserData> userData) {
//        this.userData = userData;
//    }
//
//public void setShippingData(List<ShippingData> shippingData) {
//   this.shippingData = shippingData;
//  }
//
//    public void setPaymentData(List<PaymentData> paymentData) {
//        this.paymentData = paymentData;
//    }
//
//    @Override
//    public String toString() {
//        return "TestData{" +
//                "userData=" + userData +
//                ", shippingData=" + shippingData +
//                ", paymentData=" + paymentData +
//                '}';
//    }
}
