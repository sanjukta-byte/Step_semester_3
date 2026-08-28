import java.util.Scanner;

public class LoginAttempt {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter correct access code: ");
        String correctCode = sc.nextLine();

        boolean granted = false;

        for (int i = 1; i <= 3; i++) {

            System.out.print("Enter attempt " + i + ": ");
            String attempt = sc.nextLine();

            if (attempt.equals(correctCode)) {
                System.out.println("Access granted on attempt " + i);
                granted = true;
                break;
            }
        }

        if (!granted) {
            System.out.println("Access denied — all attempts used");
        }

        sc.close();
    }
}