package payment;

public class ListPayment {
    private String cardNumber;
    private String expires;
    private String CCV;

    public ListPayment(String cardNumber, String expires, String CCV){
        this.cardNumber=cardNumber;
        this.expires=expires;
        this.CCV=CCV;
    }
    public static ListPayment preparePayments() {
        CCV ccv = new CCV();
        Expires expires = new Expires();
        numerKarty nowyNumer = new numerKarty();
        String wygasa = expires.losowanieWygasania(true);
        String numer = ccv.losowanie(true);
        String nowyNumerKarty = nowyNumer.losowanieKarty(true);

        return new ListPayment(nowyNumerKarty,wygasa,numer);

    }
    @Override
    public String toString() {
        return "ListPayment{" +
                "cardNumber='" + cardNumber + '\'' +
                ", expires='" + expires + '\'' +
                ", CCV='" + CCV + '\'' +
                '}';
    }
}
