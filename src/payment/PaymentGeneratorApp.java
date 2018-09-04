package payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaymentGeneratorApp {
        public static void main(String[] args) {
        Integer iloscDanych;
        Scanner scanner = new Scanner(System.in);
        iloscDanych = scanner.nextInt();
        List<ListPayment> paymentsData = new ArrayList<>();
        for(int i=1;i<=iloscDanych;i++){

            paymentsData.add(ListPayment.preparePayments());
            System.out.println(ListPayment.preparePayments());

            System.out.println("..............................");

        }


    }

}
