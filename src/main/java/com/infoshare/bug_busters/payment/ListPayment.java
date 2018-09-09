package main.java.com.infoshare.bug_busters.payment;


import com.infoshare.bug_busters.random.RandomDataGenerator;

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

    //Główna metoda zwracająca losowe dane
    public static ListPayment preparePayments() {

        //najprawdopodobnie niepotrzebne boolean ale zostawiam
        String CardRandomString = RandomDataGenerator.CardNumberRandom();
        String CardExpiresString = RandomDataGenerator.Expires();
        String randomCCVString = RandomDataGenerator.RandomCCV();

        //Co i jak ma zwracać
        return new ListPayment(CardRandomString,CardExpiresString,randomCCVString);

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
