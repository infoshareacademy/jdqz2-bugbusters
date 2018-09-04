package payment;

import java.util.Scanner;

public class PaymentGeneratorApp {
        public static void main(String[] args) {
	// write your code here
        Integer iloscDanych;
        Scanner scanner = new Scanner(System.in);
        iloscDanych = scanner.nextInt();

        //System.out.println(iloscDanych);
        for(int i=1;i<=iloscDanych;i++){
            CCV ccv = new CCV();
            Expires expires = new Expires();
            numerKarty nowyNumer = new numerKarty();
            String wygasa = expires.losowanieWygasania(true);
            Integer numer = ccv.losowanie(true);
            String nowyNumerKarty = nowyNumer.losowanieKarty(true);
            System.out.println(numer);
            System.out.println(wygasa);
            System.out.println(nowyNumerKarty);

        }

    }
}
