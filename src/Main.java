import java.util.Random;

public class Main {

    public static void main(String[] args) {

        String userName[] = { "Karol", "Wojtek", "Dorota", "Marian", "Krzysiek", "Jan" };

        String randomElement = userName[new Random().nextInt(userName.length)];


        System.out.println(randomElement);

    }
}
