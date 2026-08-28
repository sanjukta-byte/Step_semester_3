import java.util.Scanner;

public class PalindromeNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int original = number;
        int reversed = 0;

        while (number != 0) {

            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number = number / 10;
        }

        if (reversed == original) {
            System.out.println(
                    "Is the number " + original +
                    " a Palindrome? true"
            );
        } else {
            System.out.println(
                    "Is the number " + original +
                    " a Palindrome? false"
            );
        }

        sc.close();
    }
}