import java.util.Scanner;
public class User {
    String name;
    String userId;
    String password;
    int pin;

    public User() {
        name = "Bektur";
        userId = "Bektur13";
        password = "12345678";
        pin = 1335;
    }


    public void registerUser() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your Name: ");
        String userName = reader.nextLine();
        System.out.println("Enter your User ID: ");
        String userId = reader.nextLine();
        System.out.println("Enter your Password: ");
        String password = reader.nextLine();
        System.out.println("Enter your PIN: ");
        int pin = Integer.parseInt(reader.nextLine());
        reader.close();
    }

    public void authenticateUser() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter your UserID: ");
        String userId = reader.nextLine();
        System.out.println("Enter your Password: ");
        String password = reader.nextLine();
        reader.close();
    }
}
