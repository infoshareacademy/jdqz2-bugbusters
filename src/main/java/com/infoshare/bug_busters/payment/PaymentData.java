package com.infoshare.bug_busters.payment;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PaymentData {

    @XmlAttribute(name = "cardNumber")
    String cardNumber;
    @XmlAttribute(name="expires")
    String expires;
    @XmlAttribute(name="ccv")
    String ccv;

    public PaymentData() {
    }

    public PaymentData(String cardNumber, String expires, String CCV){

        this.cardNumber=cardNumber;
        this.expires=expires;
        this.ccv=CCV;

    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpires() {
        return expires;
    }

    public String getCcv() {
        return ccv;
    }

    @Override
    public String toString() {
        return "ListPayment{" +
                "cardNumber='" + cardNumber + '\'' +
                ", expires='" + expires + '\'' +
                ", CCV='" + ccv + '\'' +
                '}';
    }
}
