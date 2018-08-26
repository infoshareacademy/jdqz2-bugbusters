import registration.UserData;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserDataApp {

    public static void main(String[] args) {
        int numberOfUsers = 5;

        List<UserData> users = new ArrayList<>();

        for (int i = 0; i < numberOfUsers; i++) {
            prepareUser();
        }

    }



    private static void prepareUser() {
        String userName = prepareUserName(); //"Karol"
        String firstName = prepareFirstName();
        String lastName= ;
        String email;
        String password;

        UserData nowy = new UserData(userName,firstName,lastName,email,password);
    }

    private static String prepareUserName() {
        String userName[] = { "Karol", "Wojtek", "Dorota", "Marian", "Krzysiek", "Jan" };
        String randomUserName = userName[new Random().nextInt(userName.length)];
        System.out.println(userName);}

        private static String prepareFirstName() {
            String[] firstName = {"Aneta", "Joanna", "Tomek", "WOjtek", "Czarek"};
            String randomfirstName = firstName[new Random().nextInt(userName.length)];
            System.out.println(randomfirstName);
        }
        String []lastName = {"Aneta","Joanna","Tomek","WOjtek","Czarek"};
        String randomlastName = lastName [new Random().nextInt(userName.length)];
        System.out.println(randomlastName);






        String randomElement = userName[new Random().nextInt(userName.length)];

        String randomfirstName = firstName[new Random().nextInt(userName.length)];
        return randomElement;











    }


}
