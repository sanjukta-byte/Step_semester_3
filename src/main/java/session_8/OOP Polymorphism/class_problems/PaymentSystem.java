
import java.util.Scanner;

interface Payment {
    double calculate(double amount);
}

class CardPayment implements Payment {
    public double calculate(double amount) {
        return amount * 1.02;
    }
}

class WalletPayment implements Payment {
    public double calculate(double amount) {
        return amount * 1.01;
    }
}

class BankTransfer implements Payment {
    public double calculate(double amount) {
        return amount;
    }
}

class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Payment p;

            switch (type) {
                case "CARD":
                    p = new CardPayment();
                    break;
                case "WALLET":
                    p = new WalletPayment();
                    break;
                default:
                    p = new BankTransfer();
            }

            double result = p.calculate(amount);
            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}