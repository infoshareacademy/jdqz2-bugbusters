package payment;

public class ListPayment {
    //Troche skjopiowane ale zatwierdzenie typu danych dla preprarePayments
    private String cardNumber;
    private String expires;
    private String CCV;
    //Jak się mają zapisywać dane
    public ListPayment(String cardNumber, String expires, String CCV){
        this.cardNumber=cardNumber;
        this.expires=expires;
        this.CCV=CCV;
    }

    //Główna metoda zwracająca losowe dane z metod CCV, Expires, numerKarty
    public static ListPayment preparePayments() {

        //Skąd ma czerpać metody dla losowych danych
        CCV ccv = new CCV();
        Expires expires = new Expires();
        numerKarty nowyNumer = new numerKarty();

        //najprawdopodobnie niepotrzebne boolean ale zostawiam
        String wygasa = expires.losowanieWygasania(true);
        String numer = ccv.losowanie(true);
        String nowyNumerKarty = nowyNumer.losowanieKarty(true);

        //Co i jak ma zwracać
        return new ListPayment(nowyNumerKarty,wygasa,numer);

    }
    //zamienienie Hashcodu na coś czytelnego
    @Override
    public String toString() {
        return "ListPayment{" +
                "cardNumber='" + cardNumber + '\'' +
                ", expires='" + expires + '\'' +
                ", CCV='" + CCV + '\'' +
                '}';
    }
}
