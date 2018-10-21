package com.infoshare.bug_busters.payment;

import javax.xml.bind.annotation.XmlAttribute;

public class PaymentData {

    @XmlAttribute
    private String cardNumber;
    @XmlAttribute
    private String expires;
    @XmlAttribute
    private String ccv;

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
