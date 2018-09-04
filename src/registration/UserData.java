package registration;

public class UserData {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserData(String userName, String firstName, String lastName, String email, String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;

    }

public static void main (String[]args){

    String userName [] = {"Karol", "Dorota", "Wojtek", "Marian", "Jan"};
    String randomuserName = userName[new Random().nextInt(userName.length)];
    System.out.println(randomuserName);
    String firstName [] = {"Karol", "Dorota", "Wojtek", "Marian", "Jan"};
    String randomfirstName = firstName[new Random().nextInt(firstName.length)];
    System.out.println(randomfirstName);
    String lastName [] = {"Kowalski", "Nowak", "Turecki", "Jankowski", "Sobieski"};
    String randomlastName = lastName[new Random().nextInt(lastName.length)];
    System.out.println(randomlastName);
}

}
