import java.util.Scanner;

interface BasicSecurity {

    void login();

    void logout();
}

interface AdvancedSecurity extends BasicSecurity {

    void fingerprintAuthentication();

    void faceAuthentication();
}


class BankingApplication implements AdvancedSecurity {

    String username;

    BankingApplication(String username) {
        this.username = username;
    }

    @Override
    public void login() {
        System.out.println("\nUser " + username + " logged in successfully.");
    }

    @Override
    public void logout() {
        System.out.println("\nUser " + username + " logged out successfully.");
    }

    @Override
    public void fingerprintAuthentication() {
        System.out.println("\nFingerprint authentication successful.");
    }

    @Override
    public void faceAuthentication() {
        System.out.println("Face recognition authentication successful.");
    }
}

public class BankingSecurityDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("MOBILE BANKING APPLICATION");
        System.out.println("---------------------------");

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        BankingApplication bank =
            new BankingApplication(username);

        System.out.println("\n--- Basic Security Operations ---");

        bank.login();

        System.out.println("\n--- Advanced Security Operations ---");

        bank.fingerprintAuthentication();
        bank.faceAuthentication();

        System.out.println("\n--- Logout ---");

        bank.logout();

        sc.close();
    }
}