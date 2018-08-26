package src.registration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserDataGenerator {



    public static void main(String[] args) {
        int numberOfUsers = 5;

        List<UserData> users = new ArrayList<>();

        for (int i = 0; i < numberOfUsers; i++) {
            prepareUser();
        }

    }
+
    private static void prepareUser() {
        String userName = prepareUserName(); //"Karol"
        String firstName = prepareFirstName();
        String lastName=prepareLastName() ;
        String email=prepareEmail();
        String password=preparePassword();

        UserData nowy = new UserData(userName,firstName,lastName,email,password);
    }

    private static String prepareUserName() {
        String userName[] = { "Karol", "Wojtek", "Dorota", "Marian", "Krzysiek", "Jan" };
        String randomUserName = userName[new Random().nextInt(userName.length)];
        System.out.println(randomUserName);
        return randomUserName;
    }


    private static String prepareFirstName() {
        String[] firstName = {"Aneta", "Joanna", "Tomek", "WOjtek", "Czarek"};
        String randomfirstName = firstName[new Random().nextInt(firstName.length)];
        System.out.println(randomfirstName);
        return randomfirstName;
    }

    private static  String prepareLastName() {
        String[] lastName = {"Aneta", "Joanna", "Tomek", "WOjtek", "Czarek"};
        String randomlastName = lastName[new Random().nextInt(lastName.length)];
        return randomlastName;

    }

    private static  String prepareEmail () {
        String[] email = {"test", "test1", "test2", "test3", "test4"};
        String randomEmail = email[new Random().nextInt(email.length)];
        return  randomEmail;

    }
    private static  String preparePassword () {
        String[] password = {"test", "test1", "test2", "test3", "test4"};
        String randompasssword = password[new Random().nextInt(password.length)];
        return preparePassword();


    }
}
