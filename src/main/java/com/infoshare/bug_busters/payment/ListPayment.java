package main.java.com.infoshare.bug_busters.payment;

public class ListPayment {
    //Troche skjopiowane ale zatwierdzenie typu danych dla preprarePayments
    private String cardNumber;
    private String expires;
    private String ccv;
    //Jak się mają zapisywać dane
    public ListPayment(String cardNumber, String expires, String CCV){
        this.cardNumber=cardNumber;
        this.expires=expires;
        this.ccv=CCV;
    }

    //zamienienie Hashcodu na coś czytelnego
    @Override
    public String toString() {
        return "ListPayment{" +
                "cardNumber='" + cardNumber + '\'' +
                ", expires='" + expires + '\'' +
                ", CCV='" + ccv + '\'' +
                '}';
    }
}
